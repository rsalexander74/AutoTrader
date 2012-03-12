package org.daggre.autotrader.communication;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.NewCookie;

import Json.communication.*;

public class InformationCommunicator implements InfoCommInterface{
	static String strBaseUrl = "http://dev.daggre.org";
	static String strLoginSvcUrl = "/login/external_login";
	static String strUserInfoSvcUrl = "/login/current_user_info";
	static String paramUsername = "username";
	static String paramPassword = "password";
	static String paramFormat = "format";
	static String valFormat = "json";
	static NewCookie sessionCookie;
	static String strQuestion="/trade/history?format=json&question_id=";
	
	//static String strTradeSetter="/estimate/trade?idx=173&val=3";
InformationCommunicator(){}
public String getEstimateDate(int quesId,String username,String password){
	String date=null;
	ClientConfig config = new DefaultClientConfig();			
	Client client = Client.create(config);						
	WebResource webResource = client.resource(getBaseURI(strBaseUrl+strLoginSvcUrl));		
		try {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add(paramUsername, username);
		queryParams.add(paramPassword, password);
		ClientResponse response = webResource.queryParams(queryParams).head();
		List<NewCookie> cookieList = response.getCookies();
		webResource = client.resource(getBaseURI(strBaseUrl+strUserInfoSvcUrl));
		WebResource.Builder builder = webResource.getRequestBuilder();
		for (NewCookie c : cookieList) {
		    builder = builder.cookie(c);
		    sessionCookie = c;	//also save cookie for future use
		}
		webResource = client.resource("http://dev.daggre.org/questions/?format=json");
		builder = webResource.getRequestBuilder();
		builder.cookie(sessionCookie);
		String response3 = builder.get(String.class);
		JSONArray jsonArray=new JSONArray(response3);
		JSONObject json=new JSONObject();
		for(int i=0;i<jsonArray.length();i++){
		     json=jsonArray.getJSONObject(i);
		     int id=json.getInt("id");
		     if(id==quesId){
			       date=json.getString("settlement_at");
			       break;
		                   }//if end
		           else
			       continue;
		
		}//for end
		}//try end
		
		
	catch (Exception e) {
		System.out.println("Error in building and sending get requests: " + e);		
	                    }

           return date;
}//method end

private static URI getBaseURI(String strUrl) {
	return UriBuilder.fromUri(strUrl).build();
	
}




public int[] quesHistory(int quesId,String username,String password){
	int[] history=null;
	double value;
	ClientConfig config = new DefaultClientConfig();			
	Client client = Client.create(config);						
	WebResource webResource = client.resource(getBaseURI(strBaseUrl+strLoginSvcUrl));		
		try {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add(paramUsername, username);
		queryParams.add(paramPassword, password);
		ClientResponse response = webResource.queryParams(queryParams).head();
		List<NewCookie> cookieList = response.getCookies();
		webResource = client.resource(getBaseURI(strBaseUrl+strUserInfoSvcUrl));
		WebResource.Builder builder = webResource.getRequestBuilder();
		for (NewCookie c : cookieList) {
		    builder = builder.cookie(c);
		    sessionCookie = c;	//also save cookie for future use
		}
		webResource = client.resource(strBaseUrl+strQuestion+quesId);
		builder = webResource.getRequestBuilder();
		builder.cookie(sessionCookie);
		String response3 = builder.get(String.class);
		JSONArray jsonArray=new JSONArray(response3);
		int len=jsonArray.length();
		history=new int[len];
		//System.out.println(response3);
		JSONObject json=new JSONObject();
		for(int i=0;i<jsonArray.length();i++){
		json=jsonArray.getJSONObject(i);
		value=(json.getDouble("new_value"))*100;
		//System.out.println(value);
		history[i]=(int)value;
		//System.out.println(history[i]);
		}
		}
		
	catch (Exception e) {
		System.out.println("Error in building and sending get requests: " + e);		
	}

return history;
}
@Override
public int setTrade(int commitTrade,int quesId,String username,String password) {
	// TODO Auto-generated method stub
	double valueSet = 0;
	
	ClientConfig config = new DefaultClientConfig();			
	Client client = Client.create(config);						
	WebResource webResource = client.resource(getBaseURI(strBaseUrl+strLoginSvcUrl));		
		try {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add(paramUsername, username);
		queryParams.add(paramPassword, password);
		ClientResponse response = webResource.queryParams(queryParams).head();
		List<NewCookie> cookieList = response.getCookies();
		webResource = client.resource(getBaseURI(strBaseUrl+strUserInfoSvcUrl));
		WebResource.Builder builder = webResource.getRequestBuilder();
		for (NewCookie c : cookieList) {
		    builder = builder.cookie(c);
		    sessionCookie = c;	//also save cookie for future use
		}
		webResource = client.resource(strBaseUrl+"/estimate/trade?idx="+quesId+"&val="+commitTrade);
		builder = webResource.getRequestBuilder();
		builder.cookie(sessionCookie);
		String response3 = builder.get(String.class);
		valueSet=(Double.parseDouble(response3)*100);
		}
		
	catch (Exception e) {
		System.out.println("Error in building and sending get requests: " + e);		
	}
	return (int)valueSet;


}
@Override
public double[] getPoints(String username, String password) {
	// TODO Auto-generated method stub
	double[] points=null;
	
	ClientConfig config = new DefaultClientConfig();			
	Client client = Client.create(config);						
	WebResource webResource = client.resource(getBaseURI(strBaseUrl+strLoginSvcUrl));		
		try {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add(paramUsername, username);
		queryParams.add(paramPassword, password);
		ClientResponse response = webResource.queryParams(queryParams).head();
		List<NewCookie> cookieList = response.getCookies();
		webResource = client.resource(getBaseURI(strBaseUrl+strUserInfoSvcUrl));
		WebResource.Builder builder = webResource.getRequestBuilder();
		for (NewCookie c : cookieList) {
		    builder = builder.cookie(c);
		    sessionCookie = c;	//also save cookie for future use
		}
		webResource = client.resource(strBaseUrl+strUserInfoSvcUrl);
		builder = webResource.getRequestBuilder();
		builder.cookie(sessionCookie);
		String response3 = builder.get(String.class);
		JSONObject json=new JSONObject(response3);
		
		points=new double[3];
		points[0]=json.getDouble("cash_committed");
		points[1]=json.getDouble("cash_free");
		points[2]=json.getDouble("score");
	
		}
		
		
	catch (Exception e) {
		System.out.println("Error in building and sending get requests: " + e);		
	}

return points;
	
}


}

