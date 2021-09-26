package net.codejava.domain;

import java.io.Serializable;

public class Portfolio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8312958949811020156L;
	private int portfolioId;
	private String name;
	private double unitPrice;
	private int share;
	
	public Portfolio() {}

	/**
	 * @param name
	 * @param unitPrice
	 * @param share
	 */
	public Portfolio(String name, double unitPrice, int share) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.share = share;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the share
	 */
	public int getShare() {
		return share;
	}

	/**
	 * @param share the share to set
	 */
	public void setShare(int share) {
		this.share = share;
	}

	/**
	 * @return the portfolioId
	 */
	public int getPortfolioId() {
		return portfolioId;
	}

	/**
	 * @param portfolioId the portfolioId to set
	 */
	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	
	

}
