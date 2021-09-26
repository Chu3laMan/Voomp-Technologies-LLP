package net.codejava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.codejava.domain.Portfolio;

@Repository
public class PortfolioRepositoryImpl implements PortfolioRepository {
	
	public static final class PortfolioMapper implements RowMapper<Portfolio> {

		@Override
		public Portfolio mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Portfolio p = new Portfolio();
			p.setName(rs.getString("TICKER_SYMBOL"));
			p.setUnitPrice(rs.getDouble("PRICE"));
			p.setShare(rs.getInt("SHARE"));
			p.setCumulative(rs.getLong("CUMULATIVE"));
			return p;
		}
		
	}
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	@Override
	public void addPortfolio(Portfolio p) {
		String insertQuery = "INSERT INTO PORTFOLIO(TICKER_SYMBOL, "
				+ "PRICE,"
				+ "SHARE) "
				+ "VALUES(:ticker_symbol, :price, :share)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker_symbol", p.getName());
		params.put("price", p.getUnitPrice());
		params.put("share", p.getShare());
		namedParameterJdbcTemplate.update(insertQuery, params);
	}

	@Override
	public List<Portfolio> getAllPortfolios() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Portfolio> result = namedParameterJdbcTemplate.query("SELECT TICKER_SYMBOL, PRICE, SHARE, ROUND(((PRICE - 100) * SHARE), 2) AS CUMULATIVE FROM PORTFOLIO", params, new PortfolioMapper());
		return result;
	}

	@Override
	public void update(Portfolio p) {
		  String sql="UPDATE PORTFOLIO SET TICKER_SYMBOL='"+p.getName()+"', PRICE="+p.getUnitPrice()+",SHARE='"+p.getShare()+"' where id="+p.getPortfolioId()+"";
		  jdbcTemplate.update(sql);
		  
		
	}

	@Override
	public void delete(long portfolioId) {
		jdbcTemplate.update("DELETE PORTFOLIO WHERE id = ?",
				portfolioId);
		
	}

	@Override
	public Portfolio getPortfolioById(long portfolioId) {
		String query = "SELECT * FROM PORTFOLIO WHERE portfolioID = ?";
		return jdbcTemplate.queryForObject(query, new PortfolioMapper2(), portfolioId);
	}
	
	public static final class PortfolioMapper2 implements RowMapper<Portfolio> {

		@Override
		public Portfolio mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Portfolio p = new Portfolio();
			p.setName(rs.getString("TICKER_SYMBOL"));
			p.setUnitPrice(rs.getDouble("PRICE"));
			p.setShare(rs.getInt("SHARE"));
			return p;
		}
		
	}

	

}
