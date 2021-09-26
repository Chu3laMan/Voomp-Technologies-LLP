package net.codejava.service;

import java.util.List;

import net.codejava.domain.Portfolio;

public interface PortfolioService {
	
	public void addPortfolio(Portfolio p);
	public List<Portfolio> getAllPortfolios();
	public void update(Portfolio p);
	public void delete(long id);
	public Portfolio getPortfolioById(long portfolioId);

}
