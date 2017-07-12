package learn.zxl.boot;

import learn.zxl.boot.config.dbs.MasterDataSourceConfig;
import learn.zxl.boot.config.dbs.MybatisConfig;
import learn.zxl.boot.config.dbs.SlaveDataSourceConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Import({ MasterDataSourceConfig.class, SlaveDataSourceConfig.class, MybatisConfig.class})
@ImportResource({ "classpath:spring/spring-base.xml" })
@PropertySource(value = {"classpath:boot-config.properties", "classpath:important.properties"})
@ComponentScan({ "learn.zxl.boot" })
public class StartUp extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}
}
