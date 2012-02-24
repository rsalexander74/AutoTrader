package org.daggre.autotrader.reasoning;

public class TradingManager implements TradingManagerIntfc {
	TradingManager(){}
	//trading operations
	//calculation according to the data available like question history
	public void	exploreTrade(){
		System.out.println("explore trade");
	}
	// calculation according points available and other criteria 
	public void reviseTrade(){
		System.out.println("revise trade");
	}	
	// committing the trade 
	public void commitTrade(){
		System.out.println("commit trade");
	}




}
