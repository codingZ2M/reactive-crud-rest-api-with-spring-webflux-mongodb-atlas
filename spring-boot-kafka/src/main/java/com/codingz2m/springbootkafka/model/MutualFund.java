package com.codingz2m.springbootkafka.model;

public class MutualFund {
	
	private int id;
	private String fundName;
	private String fundType;
	private double 	nav;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public double getNav() {
		return nav;
	}
	public void setNav(double nav) {
		this.nav = nav;
	}
	@Override
	public String toString() {
		return "MutualFund [id=" + id + ", fundName=" + fundName + ", fundType=" + fundType + ", nav=" + nav + "]";
	}
	
	

}
