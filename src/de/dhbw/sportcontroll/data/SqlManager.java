package de.dhbw.sportcontroll.data;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import java.io.File;



public class SqlManager {
	
	
	private Connection connection;
	
	
	public boolean dbExists(File db){
		return false;
	}
	
	public boolean dbCreate(File db){
		return false;
	}
	
	public void dbConnect(File db){
		//TODO file checks 
			
		String dbFileName = db.getAbsolutePath();
		Class.forName("org.sqlite.JDBC");
	    connection = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);	    
	    	
	}
	
	public ResultSet dbQuery(String query){
		Statement st = this.connection.createStatement();
		st.
		
	}

}


  public static void main(String[] args) throws Exception
  {
    
	  
	Statement stat = conn.createStatement();
    stat.executeUpdate("drop table if exists people;");
    stat.executeUpdate("create table people (name, occupation);");
    PreparedStatement prep = conn.prepareStatement("insert into people values (?, ?);");
 
    prep.setString(1, "Gandhi");
    prep.setString(2, "politics");
    prep.addBatch();
 
    prep.setString(1, "Turing");
    prep.setString(2, "computers");
    prep.addBatch();
 
    prep.setString(1, "Wittgenstein");
    prep.setString(2, "smartypants");
    prep.addBatch();
 
    conn.setAutoCommit(false);
    prep.executeBatch();
    conn.setAutoCommit(true);
 
    ResultSet rs = stat.executeQuery("select * from people;");
    while (rs.next())
    {
      System.out.println("name = " + rs.getString("name"));
      System.out.println("job = " + rs.getString("occupation"));
    }
  
    rs.close();
    conn.close();
  }
}