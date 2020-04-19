package cn.jg.boot.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration // 当前类是配置文件，会自动创建对象执行，配置类中必须包含@Bean
public class MybatisConfiguration {
	// @Bean 方法级别的注解，告知方法要产生一个Bean，交由spring容器管理
	// 产生Bean的方法只会调用一次
	// @ConditionalOnMissingBean 当Bean存在时，不执行注解下的代码块
	// @ConditionalOnMissingBean和@Bean一起使用， @Bean可以单独使用
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		// 设置数据源
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 设置mybatis配置文件路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		// 创建对象，读取mybatis的映射文件 *mapper.xml
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 声明数组存放获取到的映射文件
		Resource[] mapperxml = null;
		// 读取映射文件到数组中
		try {
			mapperxml = resolver.getResources("classpath:mybatis/mapper/*.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 把读取到的映射文件，设置到工厂中
		sqlSessionFactoryBean.setMapperLocations(mapperxml);
		// 给工厂对象设置类的别名
		sqlSessionFactoryBean.setTypeAliasesPackage("cn.jg.boot.pojo");
		return sqlSessionFactoryBean;
	}
	
	// @ConditionalOnBean() 在哪个Bean存在的情况下，才执行下面的代码块
	@Bean
	@ConditionalOnBean(SqlSessionFactoryBean.class)
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		// 设置dao包的路径
		msc.setBasePackage("cn.jg.boot.dao");
		return msc;
	}
}












