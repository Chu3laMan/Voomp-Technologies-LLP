package net.codejava.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.dao.PortfolioRepository;
import net.codejava.dao.PortfolioRepositoryImpl;

@Configuration
public class PortfolioConfiguration {
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() throws PropertyVetoException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/VoompDB");
		dataSource.setUsername("root");
		dataSource.setPassword("aze102030.");
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean 
	public PortfolioRepository portfolioRepository() throws PropertyVetoException {
		PortfolioRepositoryImpl portfolioRepositoryImpl = new PortfolioRepositoryImpl();
		portfolioRepositoryImpl.setJdbcTemplate(jdbcTemplate()); // injection happens here
		return portfolioRepositoryImpl;
	}
	

}
