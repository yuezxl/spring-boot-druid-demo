package learn.zxl.boot.config.dbs;

import java.util.Properties;

import javax.sql.DataSource;

import learn.zxl.util.mybatis.PerformanceInterceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages = SlaveDataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourceConfig {
	static final String MAPPER_PACKAGE = "learn.zxl.boot.dao.slave";
	
	@Value("${slave.datasource.url}")
	private String url;
	@Value("${slave.datasource.username}")
	private String user;
	@Value("${slave.datasource.password}")
	private String password;
	@Value("${slave.datasource.driverClassName}")
	private String driverClass;
	
	@Bean(name = "slaveDataSource")
	public DataSource masterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean(name = "slaveSqlSessionFactory")
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(slaveDataSource);
		sessionFactory.setPlugins(new Interceptor[] {new PerformanceInterceptor()});
		return sessionFactory.getObject();
	}
	
	/**
	 * 初始化分页插件<br/>
	 *
	 * @return Interceptor
	 */
	public Interceptor pageHelperInit() {
		Properties p = new Properties();
		p.setProperty("dialect", "mysql");
		p.setProperty("reasonable", "true");
		//p.setProperty("mappers", "tk.mybatis.mapper.common.Mapper,learn.zxl.boot.util.mybatis.provider.DemoProvider");
		p.setProperty("pageSizeZero", "false");
		p.setProperty("reasonable", "true");
		Interceptor interceptor = new PageHelper();
		interceptor.setProperties(p);
		return interceptor;
	}
}
