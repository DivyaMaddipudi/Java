package virus_threat_usingCollections;

import java.sql.*;
import java.util.stream.Collectors;
import java.util.*;



public class VirusThreat {
		
	public static void main(String[] args) throws SQLException, Exception {
		
		List<DistrictWise> DistrictwiseList = new ArrayList<DistrictWise>();
		
		
		
	/*
	 * 
	 * ----------When Table is Not Stored in the database----------------
	 * 
		DistrictwiseList.add(new DistrictWise("TamilNadu", "Chennai", 60, 30));
		DistrictwiseList.add(new DistrictWise("TamilNadu", "Coimbtore", 25, 10));
		DistrictwiseList.add(new DistrictWise("AP", "Chitoor", 15, 20));
		DistrictwiseList.add(new DistrictWise("AP", "Vijayawada", 45, 31));
		DistrictwiseList.add(new DistrictWise("Kerala", "Cochin", 75, 45));
		DistrictwiseList.add(new DistrictWise("Kerala", "Wayanad", 15, 15));
		
		//DistrictwiseList.forEach(item->System.out.println(item));
		
		Map<String, Integer> maleList = DistrictwiseList.stream().collect(
			    Collectors.groupingBy(DistrictWise::getState, Collectors.summingInt(DistrictWise::getMale)));

		Map<String, Integer> femaleList = DistrictwiseList.stream().collect(
			    Collectors.groupingBy(DistrictWise::getState, Collectors.summingInt(DistrictWise::getFemale)));
		
		//Total Females
		
		System.out.println("Total female patients in different states: \n");
		
		femaleList.forEach((k, v) -> System.out.println(k + " "+ v));
		
		//Total males
		
		System.out.println("\nTotal male patients in different states: \n");
		
		maleList.forEach((k, v) -> System.out.println(k + " "+ v));
		
		
		
		//Total Patients in Different states
		
		maleList.forEach((key, value) -> femaleList.merge(key, value, (v1, v2) -> v1.equals(v2) ? v1 : v1 + v2 ));

		System.out.println("\nTotal patients in different states: \n");
		
		femaleList.forEach((k, v) -> System.out.println(k + " "+ v));
		
		// Total Infected People 
		
					Integer totalMale = 0, totalFemale = 0;
					Integer Total = 0;
					
						for(DistrictWise i: DistrictwiseList) {
							totalMale += i.getMale();
							totalFemale += i.getFemale();
						}
						Total = totalMale + totalFemale;
						System.out.println("Total People Infected: " + Total);
		 * 
		 * 
		 * 
		 */
		
		
		/*
		 * --------------- When table is stored in the database and accessed through collections --------------------
		 */
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		

		String dburl = "jdbc:mysql://localhost:3306/virus";
		String user = "student";
		String pass = "student";
		Class.forName("com.mysql.jdbc.Driver");//class forname
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(dburl, user, pass);

			System.out.println("Database connection successful!\n");

			// Create a statement
			
			myStmt = myConn.createStatement();
			
			String sql = "Select * From corona";
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				DistrictWise infected = new DistrictWise();
				infected.setState(myRs.getString("state"));
				infected.setMale(myRs.getInt("male"));
				infected.setFemale(myRs.getInt("female"));
				DistrictwiseList.add(infected);
				}
			//DistrictwiseList.forEach(item->System.out.println(item));
			
			Map<String, Integer> maleList = DistrictwiseList.stream().collect(
				    Collectors.groupingBy(DistrictWise::getState, Collectors.summingInt(DistrictWise::getMale)));

			Map<String, Integer> femaleList = DistrictwiseList.stream().collect(
				    Collectors.groupingBy(DistrictWise::getState, Collectors.summingInt(DistrictWise::getFemale)));
			
			//Total Females
			
			System.out.println("Total female patients in different states: \n");
			
			femaleList.forEach((k, v) -> System.out.println(k + " female patients: "+ v));
			
			//Total males
			
			System.out.println("\nTotal male patients in different states: \n");
			
			maleList.forEach((k, v) -> System.out.println(k + " male patients: " + v));
			
			//Total Patients in Different states
			
			maleList.forEach((key, value) -> femaleList.merge(key, value, (v1, v2) -> v1.equals(v2) ? v1 : v1 + v2 ));

			System.out.println("\nTotal patients in different states: \n");
			
			femaleList.forEach((k, v) -> System.out.println(k + "total patients: "+ v));
			
			// Total Infected People 
			
						Integer totalMale = 0, totalFemale = 0;
						Integer Total = 0;
						
							for(DistrictWise i: DistrictwiseList) {
								totalMale += i.getMale();
								totalFemale += i.getFemale();
							}
							Total = totalMale + totalFemale;
							System.out.println("\nTotal Number of Patients: " + Total);    

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			}
			
	}
}



















