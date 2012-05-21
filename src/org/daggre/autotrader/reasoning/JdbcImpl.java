package org.daggre.autotrader.reasoning;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;

public class JdbcImpl {
    TradingController tdObj=new TradingController();
	Connection conn = null;
	 String url = "jdbc:mysql://127.0.0.1:3306/";
	    String dbName = "autotrader";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "autotrader"; 
	    String password = "auto+trade123";

	ResultSet rs = null;
	
//	public static void main(String[] args){
//		JdbcImpl sravan=new JdbcImpl();
//		int[] n=sravan.getQuesId();
//	
//	}
	
	
public int[] getQuesId(){
	int[] QuesId=null;
	int i=0,j=0;
	try {
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);
		java.sql.Statement st = conn.createStatement();
		
		try {
			
			String table = "SELECT Ques_ID FROM AUTOTRADER";
			rs=st.executeQuery(table);
	
		while(rs.next()){
			j++;
		}
		rs=st.executeQuery(table);
		QuesId=new int[j];
			while(rs.next()){
			QuesId[i]=rs.getInt("Ques_Id");
			i++;
			}
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		finally{
			conn.close();
			rs.close();
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return QuesId;
	}
		

public void getQuesInfo(int quesId){
	
	
	try {
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);
		Statement st = conn.createStatement();
		
		try {
			
			String table = "SELECT * FROM AUTOTRADER WHERE Ques_Id="+quesId;
			rs=st.executeQuery(table);
		if(rs.first()){
			tdObj.set_quesId(quesId);
			tdObj.set_Username(rs.getString("Username"));
			tdObj.set_Policy(rs.getInt("Policy"));		
            tdObj.set_default(rs.getInt("Default_Value"));
            tdObj.set_minNoOfDays(rs.getInt("NoOfDays"));
            tdObj.set_Max_Percentage(rs.getInt("Max_Percentage"));
            tdObj.set_Max_Points((double)rs.getInt("Max_Points"));
		}
			else
			System.out.println("no such ques exists info");
	
				
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		finally{
			conn.close();
			rs.close();
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public void getPassword(String usr){
		//String pass;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			Statement st = conn.createStatement();
			
			try {
				
				String table = "SELECT * FROM USER_INFO WHERE username='"+usr+"'";
				rs=st.executeQuery(table);
			if(rs.first()){
			tdObj.set_Password(rs.getString("password"));
			}
				else
				System.out.println("no such row exists password");
		
					
				
			} catch (SQLException s) {
				s.printStackTrace();
			}
			finally{
				conn.close();
				rs.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int[] support_info(int ques_Id){
		
		
		int[] QuesId=null;
		int i=0,j=0;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			java.sql.Statement st = conn.createStatement();
			
			try {
				
				String table = "SELECT * FROM SUPPORT_INFO WHERE Ques_Id="+ques_Id;
				rs=st.executeQuery(table);
			while(rs.next()){
				j++;
				}
			QuesId=new int[j];
			rs=st.executeQuery(table);
				while(rs.next()){
				QuesId[i]=rs.getInt("Support_Ques");
				i++;
				}
			}
			catch (SQLException s) {
				s.printStackTrace();
			}
			finally{
				conn.close();
				rs.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return QuesId;
	
		
	}
	
	public String getNodeName(int suppQues){
		
		String node=null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			Statement st = conn.createStatement();
			
			try {
				
				String table = "SELECT * FROM SUPPORT_INFO WHERE Support_Ques="+suppQues;
				rs=st.executeQuery(table);
				if(rs.first()){
					node=rs.getString("NodeName");
//					System.out.println(node);
					}
						else
						System.out.println("no such row exists");
					
				
			} catch (SQLException s) {
				s.printStackTrace();
			}
			finally{
				conn.close();
				rs.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		return node;
		
		
		
	}
	
	//returns string so shld be changed
	public void getFileName(int quesId){
		
		

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			Statement st = conn.createStatement();
			
			try {
				
				String table = "SELECT * FROM FILE_INFO WHERE Ques_Id="+quesId;
				rs=st.executeQuery(table);
				if(rs.first()){
					tdObj.set_fileName(rs.getString("FileName"));
					tdObj.set_nodeName(rs.getString("NodeName"));
					}
						else
						System.out.println("no such row exists");	
				
			} catch (SQLException s) {
				s.printStackTrace();
			}
			finally{
				conn.close();
				rs.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		
		
		
		
		
	}
	
	
}
