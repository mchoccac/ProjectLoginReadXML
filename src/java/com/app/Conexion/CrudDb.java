/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author usera
 */
public class CrudDb {

    public CrudDb() {
    
    }
    
    public void ins(String id,String nombre,String apellido,String login,String password,String sessionid){
          
        try
        { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "prueba", "prueba"); 
            Statement stmt = con.createStatement(); 
    
           String q1 = "CALL T_USUARIO_TAPI.ins('"+apellido+"',"+id+",'"+password+"','"+sessionid+"','"+login+"','"+nombre+"')"; 
           stmt.executeUpdate(q1); 
           
           con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println("Error::::::====="+e); 
        } 
    }
    
    public void upd(String id,String nombre,String apellido,String login,String password,String sessionid){
        
        try
        { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "prueba", "prueba"); 
 
            Statement stmt = con.createStatement(); 

            String q1 = "CALL T_USUARIO_TAPI.UPD('"+apellido+"',"+id+",'"+password+"','"+sessionid+"','"+login+"','"+nombre+"')"; 
            stmt.executeUpdate(q1); 
     
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println("Error::::::====="+e); 
        } 
    } 

    public void del(String id){
        try
        { 
          Class.forName("oracle.jdbc.driver.OracleDriver"); 
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "prueba", "prueba"); 
 
            Statement stmt = con.createStatement(); 
                   
            String q1 = "CALL T_USUARIO_TAPI.DEL("+id+")"; 
                      
            stmt.executeUpdate(q1); 
              
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println("Error::::::====="+e); 
        } 
    }

    public boolean selectId(String login,String password){
        boolean estado = false;
        try
        { 
          Class.forName("oracle.jdbc.driver.OracleDriver"); 
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "prueba", "prueba"); 
 
          Statement stmt = con.createStatement(); 
              

            String q1 = "select LOGIN,PASSWORD from T_USUARIO where LOGIN = '"+login+"' and PASSWORD = '"+password+"'"; 
            ResultSet rs = stmt.executeQuery(q1); 
            if (rs.next()) 
            { 
                System.out.println("id: " + rs.getString(1)); 
                System.out.println("nombre :" + rs.getString(2));
                estado = true;
            } 
            else
            { 
                System.out.println("no existe el id"); 
                estado = false;
            } 
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
        return estado;
    }
}
