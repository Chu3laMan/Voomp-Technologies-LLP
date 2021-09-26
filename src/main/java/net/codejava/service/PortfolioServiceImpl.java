package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.dao.PortfolioRepository;
import net.codejava.domain.Portfolio;

@Service
public class PortfolioServiceImpl implements PortfolioService {
	
	@Autowired
	private PortfolioRepository portfolioRepository;

	@Override
	public void addPortfolio(Portfolio p) {
		portfolioRepository.addPortfolio(p);
		
	}

	@Override
	public List<Portfolio> getAllPortfolios() {
		return portfolioRepository.getAllPortfolios();
	}

	@Override
	public void update(Portfolio p) {
		portfolioRepository.update(p);
		
	}

	@Override
	public void delete(long portfolioId) {
		portfolioRepository.delete(portfolioId);
		
	}

	@Override
	public Portfolio getPortfolioById(long portfolioId) {
		return portfolioRepository.getPortfolioById(portfolioId);
	}

}
