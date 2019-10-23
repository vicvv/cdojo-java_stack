package com.vicky.countries.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;



//What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, 
//language, and language percentage. Your query should arrange the result by language percentage in descending order.
//


//What query would you run to display the total number of cities for each country? Your query should return 
//the name of the country and the total number of cities. Your query should arrange the result by the number 
//of cities in descending order.
//
//What query would you run to get all the cities in Mexico with a population of greater than 500,000? 
//Your query should arrange the result by population in descending order.
//
//What query would you run to get all languages in each country with a percentage greater than 89%? 
//Your query should arrange the result by percentage in descending order.
//
//What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
//
//What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 
//200 and a life expectancy greater than 75 years?
//
//What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the 
//population greater than 500, 000? The query should return the Country Name, City Name, District, and Population.
//
//What query would you run to summarize the number of countries in each region? The query should display 
//the name of the region and the number of countries. Also, the query should arrange the result by the number 
//of countries in descending order.
//
//



public class Country {
	
	
	
	public static void main(String args[]) {
        String dbURL = "jdbc:mysql://localhost:3306/world?&serverTimezone=UTC";
        String username ="root";
        String password = "root";
       
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        //String query ="select count(*) from countries";
        
        String query ="SELECT c.name, l.language, l.percentage FROM countries c join languages l on l.country_id = c.id \n" + 
        		"where l.language = \"Slovene\" order by l.percentage desc;";
        
        String q2 = "SELECT c.name, count(ct.name) as count  FROM countries c join cities ct on c.id = ct.country_id group by ct.country_id\n" + 
        		"order by count desc;";
        
        String q3 = "SELECT c.name, ct.name, ct.population  FROM countries c join cities ct on c.id = ct.country_id \n" + 
        		"where c.name = \"Mexico\" and ct.population > 50000";
        
        String q4 = "SELECT c.name, l.language, l.percentage FROM countries c join languages l on l.country_id = c.id \n" + 
        		"where l.percentage > 89 order by l.percentage desc;";
        
        String q5 = "";
       
        try {
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);
           
            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
           
            //Resultset returned by query
            rs = stmt.executeQuery(query);
           
            while(rs.next()){
             //int count = rs.getInt(1);
             String res1 = rs.getString(1);
             String res2 = rs.getString(2);
             String res3 = rs.getString(3);
             System.out.println(" " + res1 + " " + res2 + " " + res3);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           //close connection ,stmt and resultset here
        }
       
    }  
   
}


