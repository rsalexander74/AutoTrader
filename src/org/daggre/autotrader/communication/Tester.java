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

import org.daggre.autotrader.reasoning.Validator;

import Json.communication.*;

public class Tester {

	/**
	 * @param args
	 */
	static String username="autotraderK3";
	static String password="ralexan3";
	static String strBaseUrl = "http://daggre.org";
	static String strLoginSvcUrl = "/login/external_login";
	static String strUserInfoSvcUrl = "/login/current_user_info";
	static String paramUsername = "username";
	static String paramPassword = "password";
	static String paramFormat = "format";
	static String valFormat = "json";
	static NewCookie sessionCookie;
	static String strQuestion="/trade/history?format=json&question_id=";
	static int quesId=124;
	
	private static URI getBaseURI(String strUrl) {
		return UriBuilder.fromUri(strUrl).build();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		int[] history=null;
		String[] history_dates=null;
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
			history_dates=new String[len];
			history_dates[i]=json.getString("created_at");
			System.out.println(history[i]+"       "+history_dates[i]);
			Validator valid=new Validator();
			
			System.out.println(valid.noOfDays(history_dates[i]));
			}
			}
			
		catch (Exception e) {
			System.out.println("Error in building and sending get requests: " + e);		
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
