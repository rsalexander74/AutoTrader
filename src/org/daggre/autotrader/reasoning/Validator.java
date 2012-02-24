package org.daggre.autotrader.reasoning;

public class Validator {
Validator(){}
// all validations required to proceed to trading
	public boolean	withinTradeWindow()
	{
	System.out.println("within trade window");
		return true;
	}
public boolean sufficientPoints()
{
	System.out.println("sufficient points");
	return true;	
}




}
