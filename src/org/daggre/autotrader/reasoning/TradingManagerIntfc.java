package org.daggre.autotrader.reasoning;

public interface TradingManagerIntfc {
//interface defining all major methods required for trading and committing
public int	exploreTrade();
public int reviseTrade(int estimatedPercentage);	
public int commitTrade(int revisedTrade);
	
	
	
	
	
	
}
