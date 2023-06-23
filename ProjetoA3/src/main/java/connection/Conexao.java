/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Marco
 */
public class Conexao {
    
   private static final String url = "jdbc:mysql://localhost:3306/projetoa3";
   private static final String user = "root";
   private static final String password = "123456";
   
   private static Connection conn;
   
    public static Connection getConexao() {
        
        try {
            if(conn == null){
               conn = DriverManager.getConnection(url, user, password);
               System.out.println("conexao ok");
               return conn;
            }else{
               return conn;
            }
        }
        catch (SQLException ex) {
           System.out.println("Driver do banco de dados não localizado");
           System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
