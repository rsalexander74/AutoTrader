package org.daggre.autotrader.reasoning;

public interface TradingManagerIntfc {
//interface defining all major methods required for trading and committing
public int	exploreTrade(int [] quesHistory);
public int reviseTrade(int estimatedPercentage,int initialPercentage);	
public int commitTrade(int revisedTrade);
	
	
	
	
	
	
}
