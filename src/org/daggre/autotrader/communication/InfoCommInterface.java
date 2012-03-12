package org.daggre.autotrader.communication;

public interface InfoCommInterface {

	
	public String getEstimateDate(int quesId,String username,String password);
	public int[] quesHistory(int quesId,String username,String password);
	public int setTrade(int commitTrade,int quesId,String username,String password);
	public double[] getPoints(String username,String password);
		
	
}
