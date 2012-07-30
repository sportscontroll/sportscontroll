package de.dhbw.sportcontroll.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


import java.io.File;

/**
 * SQLLiteManager Manages all operation concerning the direct access to the sqllite-file
 * 
 * @author daniel
 *
 */

public class SqlManager {
	
	
	private Connection connection;
	
	
	public SqlManager(String db) throws  SQLException{
		File dbF = new File(db);
		if(!dbExists(dbF)){
			dbConnect(dbF);		
		}
		else{
			//TODO
		}			
	}
	
	
	
	public boolean dbExists(File db){
		return false;
	}
	
	public boolean dbCreate(File db){
		return false;
	}
	
	public void dbConnect(File db) throws  SQLException{
		//TODO file checks 
			
		String dbFileName = db.getAbsolutePath();
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    connection = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);	    
	    	
	}
	
	/**
	 * 
	 * @param query
	 * @return ResultSet 
	 * @throws SQLException
	 */
	public ResultSet dbSingleQuery(String query) throws SQLException{
		Statement st = this.connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	/**
	 * 
	 * @param stat
	 * @return
	 * @throws SQLException 
	 */
	public boolean dbSingleStatement(String stat) throws SQLException{
		Statement st = this.connection.createStatement();
		st.getGeneratedKeys();
		return false;
		
	}
	//public ResultSet dbStatementQuery(PreparedStatement stat){
		
	public void createTables(){
		Statement stat;
		try {
			stat = connection.createStatement();		    
		    stat.executeUpdate("create table userprofile ( name, birthday, gender, height);");
		    stat.executeUpdate("create table weight (uid, date, weight);");
		    stat.executeUpdate("create table workout ( uid, did, date, duration, location);");
		    stat.executeUpdate("create table sportdiciplin ( name, caloryconsumption);");
		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
	}
	
	
	/**
	 * filling Db with dummy data
	 */
	public void fillDB(){
		createTables();		
		
		Date today = new Date();
		
		Statement stat;
		try {
			stat = connection.createStatement();
			//profiles
			stat.executeUpdate("insert into userprofile values ( 'Daniel', '01081987', 'male', 182); ");
			stat.executeUpdate("insert into userprofile values ('Katja', '20101992', 'female', 169); ");

			//weights
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			
						
			
			
			//dicipline
			stat.executeUpdate("insert into sportdiciplin (name, caloryconsumption) values ('Schwimmen', 21); ");
			stat.executeUpdate("insert into sportdiciplin (name, caloryconsumption) values ('Laufen', 25); ");
			stat.executeUpdate("insert into sportdiciplin (name, caloryconsumption) values ('Radfahren', 18); ");
			
			//workouts
			stat.executeUpdate("insert into workout values (1, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' ); ");
			stat.executeUpdate("insert into workout values (1, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' ); ");
			stat.executeUpdate("insert into workout values (2, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' ); ");
			stat.executeUpdate("insert into workout values (2, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' ); ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

/*

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
}*/