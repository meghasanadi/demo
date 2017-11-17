package sam.com.jar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AutoGenericId1 {
	static int portNumber;
	static String databaseName,userName,password;
	static Integer pattrenId;
	static Connection con;
	static PreparedStatement pstmt;
	static boolean startIncYesorNo,midIncYesorNo,endIncYesorNo,startSeparator_applicable,midSeparator_applicable,endSeparator_applicable,start_zero_fill_yesorno,mid_zero_fill_yesorno,end_zero_fill_yesorno;
	static int startIncValue,newstartCurrentValue ,midIncValue,endIncValue;
	static int startCurrentValue,startSeparator_length,midSeparator_length,endSeparator_length;
	static int midTypeInt,endTypeInt;
	static int startlength,midlength, midCurrentValue,endCurrentValue,start_zero_fill_length,mid_zero_fill_length,end_zero_fill_length;
	static String startTypeString,midtTypeString,midTypeString,endTypeString;
	static StringBuilder finalString;
	static int newendCurrentValue;
	static int finalString1;
	static int midValue;
	static String startSeparator_value,midSeparator_value,endSeparator_value;
	static int newStartValue;
	static Integer patternId1;
	

	public static void GenericId(Integer port,String db,String username,String password) {
		portNumber=port;
		databaseName=db;
		userName=username;
		AutoGenericId1.password=password;
	}



	private static Connection GetConection(int portNumber, String databaseName, String userName, String password) {
		
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:"+portNumber+"/"+databaseName,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}

	public static StringBuilder getIncrementedPattrenValue(Integer patternId1) {

		try{
			String query="Select startIncValue,startIncYesorNo,StartTypeInt,startTypeString,startCurrentValue,midIncValue,midIncYesorNo,midTypeInt,midTypeString,midCurrentValue, endIncValue,endIncYesorNo,endTypeInt,endTypeString,endCurrentValue,startSeparator_applicable,startSeparator_length,startSeparator_value,midSeparator_applicable,midSeparator_length,midSeparator_value,start_zero_fill_yesorno,start_zero_fill_length,mid_zero_fill_yesorno,mid_zero_fill_length,end_zero_fill_yesorno,end_zero_fill_length from new_autogene where patternkey='"+patternId1+"'";
			con=GetConection(portNumber,databaseName,userName,password);
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery(query);
			rs.next();

			startIncValue=rs.getInt(1);
			startIncYesorNo=rs.getBoolean(2);
			startTypeString=rs.getString(4);
			startCurrentValue=rs.getInt(5);

			midIncValue=rs.getInt(6);
			midIncYesorNo=rs.getBoolean(7);
			midTypeInt=rs.getInt(8);
			midTypeString=rs.getString(9);
			midCurrentValue=rs.getInt(10);

			endIncValue=rs.getInt(11);
			endIncYesorNo=rs.getBoolean(12);
			endTypeInt=rs.getInt(13);
			endTypeString=rs.getString(14);
			endCurrentValue=rs.getInt(15);
			
			startSeparator_applicable=rs.getBoolean(16);
			startSeparator_length=rs.getInt(17);
			startSeparator_value=rs.getString(18);
			
			midSeparator_applicable=rs.getBoolean(19);
			midSeparator_length=rs.getInt(20);
			midSeparator_value=rs.getString(21);
			
			
			/*System.out.println(startSeparator_applicable);
			System.out.println(startSeparator_length);
			System.out.println(startSeparator_value);*/
			
			/*System.out.println(" ");
			System.out.println(midSeparator_applicable);
			System.out.println(midSeparator_length);
			System.out.println(midSeparator_value);*/
			
			/*System.out.println(" ");
			System.out.println(endSeparator_applicable);
			System.out.println(endSeparator_length);
			System.out.println(endSeparator_value);*/
			
			start_zero_fill_yesorno=rs.getBoolean(22);
			start_zero_fill_length=rs.getInt(23);
			
			mid_zero_fill_yesorno=rs.getBoolean(24);
			mid_zero_fill_length=rs.getInt(25);
			
			end_zero_fill_yesorno=rs.getBoolean(26);
			end_zero_fill_length=rs.getInt(27);
			
			/*System.out.println(" ");
			System.out.println(start_zero_fill_yesorno);
			System.out.println(start_zero_fill_length);
			
			System.out.println(" ");
			System.out.println(mid_zero_fill_yesorno);
			System.out.println(mid_zero_fill_length);
			
			System.out.println(" ");
			System.out.println(end_zero_fill_yesorno);
			System.out.println(end_zero_fill_length);*/
			
		}
		catch(Exception e){
			System.out.println(e);
		}

		
		
		if((startIncYesorNo==true)&&(startSeparator_applicable==false)&&(start_zero_fill_yesorno==false)){
			int StartTypeInt=startIncValue+startCurrentValue;
           
			try{
				con=GetConection(portNumber,databaseName,userName,password);
				PreparedStatement pstmt2=con.prepareStatement("Update new_autogene set startCurrentValue='"+StartTypeInt+"' where patternkey='"+patternId1+"'");
				pstmt2.executeUpdate();    	 
			}
			catch(Exception e){
				System.out.println(e);
			}

			if((midIncYesorNo==false)&&(midSeparator_applicable==true)&&(midtTypeString!=null)){
				
				String MidString=midTypeString+midSeparator_value+midSeparator_value;
			//	System.out.println(MidString);
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(midtTypeString!=null)){
				String MidString=midTypeString;
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+newendValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}	
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)&&(midTypeString==null)){
				String MidString="";
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)&&(midTypeString!=null)){
				String MidString=midTypeString;
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
			//	
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
		
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}		
			
			
		}	
	//--------------
		if((startIncYesorNo==true)&&(startSeparator_applicable==false)&&(start_zero_fill_yesorno==true)){
			int StartTypeInt=startIncValue+startCurrentValue;
		
			try{
				con=GetConection(portNumber,databaseName,userName,password);
				PreparedStatement pstmt2=con.prepareStatement("Update new_autogene set startCurrentValue='"+StartTypeInt+"' where patternkey='"+patternId1+"'");
				pstmt2.executeUpdate();    	 
			}
			catch(Exception e){
				System.out.println(e);
			}

			if((midIncYesorNo==false)&&(midSeparator_applicable==true)&&(midtTypeString!=null)){
				
				String MidString=midTypeString+midSeparator_value+midSeparator_value;
			
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(midtTypeString!=null)){
				String MidString=midTypeString;
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
			//	
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}	
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				String MidString=midTypeString;
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
		       	
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			
		}	
	//--------------	

		
		if((startIncYesorNo==true)&&(startSeparator_applicable==true)&&(start_zero_fill_yesorno==false)){
			int StartTypeInt=startIncValue+startCurrentValue;
		
			try{
				con=GetConection(portNumber,databaseName,userName,password);
				PreparedStatement pstmt2=con.prepareStatement("Update new_autogene set startCurrentValue='"+StartTypeInt+"' where patternkey='"+patternId1+"'");
				pstmt2.executeUpdate();    	 
			}
			catch(Exception e){
				System.out.println(e);
			}

			if((midIncYesorNo==false)&&(midSeparator_applicable==true)){
				String MidString=startSeparator_value+midTypeString+midSeparator_value;
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)){
				String MidString=startSeparator_value+midTypeString;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+MidString+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				
               if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}	
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				
				int newmidIncValue=midCurrentValue+midIncValue;
			
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
		}	
//********************************
		if((startIncYesorNo==true)&&(startSeparator_applicable==true)&&(start_zero_fill_yesorno==true)){
			int StartTypeInt=startIncValue+startCurrentValue;
	
			try{
				con=GetConection(portNumber,databaseName,userName,password);
				PreparedStatement pstmt2=con.prepareStatement("Update new_autogene set startCurrentValue='"+StartTypeInt+"' where patternkey='"+patternId1+"'");
				pstmt2.executeUpdate();    	 
			}
			catch(Exception e){
				System.out.println(e);
			}

			if((midIncYesorNo==false)&&(midSeparator_applicable==true)){
				String MidString=startSeparator_value+midTypeString+midSeparator_value;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)){
				String MidString=startSeparator_value+midTypeString;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=midSeparator_value+endTypeString;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newendValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				
               if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(String.format("%04d",StartTypeInt)+startSeparator_value+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StartTypeInt+startSeparator_value+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
		}	

//********************************		
		
		
		if((startIncYesorNo==false)&&(startTypeString!=null)&&(startSeparator_applicable==true)){
			
			String StarttypeString=startTypeString+startSeparator_value;

			if((midIncYesorNo==false)&&(midSeparator_applicable==true)){
				
				String MidString=midTypeString+midSeparator_value;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
				
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				
               if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)){
				String MidString=midTypeString;
			
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				
               if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
			
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
				
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}	
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==true)&&(midtTypeString!=null)){
				
				String MidString=midtTypeString;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
	   }
		
		
//************************************************		
		
		
		if((startIncYesorNo==false)&&(startTypeString!=null)&&(startSeparator_applicable==false)){
			
			String StarttypeString=startTypeString;
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==true)){
		
				String MidString=midTypeString+midSeparator_value;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midTypeString!=null)&&(midSeparator_applicable==false)){
			//	System.out.println("---------------------------------------");
				String MidString=midTypeString;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
		
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendString);
					System.out.println(finalString);
				}
               if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
                if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)&&(midTypeString==null)){
				String MidString="";
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)&&(midTypeString!=null)){
				String MidString=midTypeString;
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				System.out.println("   "+newmidIncValue);
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			
		}
		
//****************************************			
		if((startIncYesorNo==false)&&(startTypeString==null)){
	
			String StarttypeString="";
			//System.out.println(startTypeString);
			if((midIncYesorNo==false)&&(midSeparator_applicable==true)){
				String MidString=startSeparator_value+midTypeString+midSeparator_value;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==false)&&(midSeparator_applicable==false)){
				String MidString=startSeparator_value+midTypeString;
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+MidString+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+MidString+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
		

			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+newmidIncValue+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==false)){
				int newmidIncValue=midCurrentValue+midIncValue;
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+newmidIncValue+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
			}	
			if((midIncYesorNo==true)&&(midSeparator_applicable==false)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
			
			if((midIncYesorNo==true)&&(midSeparator_applicable==true)&&(mid_zero_fill_yesorno==true)){
				int newmidIncValue=midCurrentValue+midIncValue;
				System.out.println("   "+newmidIncValue);
				try{
					con=GetConection(portNumber,databaseName,userName,password);
					PreparedStatement pstmt4=con.prepareStatement("Update new_autogene set midCurrentValue='"+newmidIncValue+"' where patternkey='"+patternId1+"'");
					pstmt4.executeUpdate();    	    
				}
				catch(Exception e){
					System.out.println(e);
				}
				if((endIncYesorNo==false)&&(endTypeString!=null)){
					String newendString=endTypeString;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==false)){
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendValue);
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
				}
				
				if((endIncYesorNo==false)&&(endTypeString==null)){
					String newendString="";
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+newendString);
					System.out.println(finalString);
				}
				if((endIncYesorNo==true)&&(end_zero_fill_yesorno==true)){
					
					int newendValue=endIncValue+endCurrentValue;
					finalString=new StringBuilder(StarttypeString+String.format("%04d",newmidIncValue)+midSeparator_value+String.format("%04d",newendValue));
					System.out.println(finalString);
					try{

						con=GetConection(portNumber,databaseName,userName,password);
						PreparedStatement pstmt3=con.prepareStatement("Update new_autogene set endCurrentValue='"+newendValue+"' where patternkey='"+patternId1+"'");
						pstmt3.executeUpdate();
					}
					catch(Exception e){
						System.out.println(e);
					}
					
				}
				
			}
		}
			
		return finalString;
	}
	
	/*public static void main(String[] args){
		getIncrementedPattrenValue(patternId1);
		
	}
*/
}
