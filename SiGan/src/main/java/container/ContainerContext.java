package container;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import controller.MainController;
import model.SiGanDAO;

@Configuration
@EnableTransactionManagement
public class ContainerContext {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/siganDatabase?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("chlwogns321@");
		
		//커넥션 풀 동작과 관련한 세부 정보설정
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		
		return ds;
	}
	
	//commit 과 rollback 수행하는 TransactionManager 객체 생성
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	@Bean
	public SiGanDAO siGanDAO() {
		return new SiGanDAO(dataSource());
	}
	
	@Bean
	public MainController mainController() {
		return new MainController();
	}
}
