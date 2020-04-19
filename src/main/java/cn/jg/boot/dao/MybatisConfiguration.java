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

@Configuration // ��ǰ���������ļ������Զ���������ִ�У��������б������@Bean
public class MybatisConfiguration {
	// @Bean ���������ע�⣬��֪����Ҫ����һ��Bean������spring��������
	// ����Bean�ķ���ֻ�����һ��
	// @ConditionalOnMissingBean ��Bean����ʱ����ִ��ע���µĴ����
	// @ConditionalOnMissingBean��@Beanһ��ʹ�ã� @Bean���Ե���ʹ��
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		// ��������Դ
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// ����mybatis�����ļ�·��
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		// �������󣬶�ȡmybatis��ӳ���ļ� *mapper.xml
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// ���������Ż�ȡ����ӳ���ļ�
		Resource[] mapperxml = null;
		// ��ȡӳ���ļ���������
		try {
			mapperxml = resolver.getResources("classpath:mybatis/mapper/*.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �Ѷ�ȡ����ӳ���ļ������õ�������
		sqlSessionFactoryBean.setMapperLocations(mapperxml);
		// ����������������ı���
		sqlSessionFactoryBean.setTypeAliasesPackage("cn.jg.boot.pojo");
		return sqlSessionFactoryBean;
	}
	
	// @ConditionalOnBean() ���ĸ�Bean���ڵ�����£���ִ������Ĵ����
	@Bean
	@ConditionalOnBean(SqlSessionFactoryBean.class)
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		// ����dao����·��
		msc.setBasePackage("cn.jg.boot.dao");
		return msc;
	}
}












