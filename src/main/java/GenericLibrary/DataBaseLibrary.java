package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This method contains database specific reusable methods
 * @author sanjay
 *
 */
public class DataBaseLibrary {

	Driver driverRef;
	Connection conn;
	
	/**
	 * This method will establish the connection with mysql database
	 * @throws SQLException
	 */
	public void connectToDataBase() throws SQLException 
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(IConstants.dbURl, IConstants.dbUserName, IConstants.dbPassword);
	}
	
	/**
	 * This method will close database connection
	 * @throws SQLException
	 */
	public void closeToDataBase() throws SQLException 
	{
		conn.close();
	}
	
	/**
	 * This method will execute the query and return the value only if the validation is passed
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String readDataFromDBAndValidate(String query,int columnIndex,String expData ) throws SQLException
	{
		boolean flag=false;
		ResultSet result = conn.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).equalsIgnoreCase(expData));
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("data verfied");
			return expData;
		}
		else {
			System.out.println("data not verified");
			return "";
		}
	}
}
