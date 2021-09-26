package net.codejava.dao;

import java.util.List;

import net.codejava.domain.Portfolio;

public interface PortfolioRepository {
	public void addPortfolio(Portfolio p);
	public List<Portfolio> getAllPortfolios();
	public void update(Portfolio p);
	public void delete(long portfolioId);
	public Portfolio getPortfolioById(long portfolioId);

}
