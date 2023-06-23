/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author Marco
 */
public class UserDAO extends User{
    
      // public UserDAO(String name, String adress, String phoneNumber, String email, String course){
//        super( name, adress, phoneNumber, email, course);
//    }
    

    
    public void addUser(User person){
        String sql = "INSERT INTO users (cpf, nome, email, pass_word, celular) VALUES(?,?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, person.getCpf());
            ps.setString(2, person.getName());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getPassword());
            ps.setString(5, person.getNumber());
            
            ps.execute();
            ps.close();
            showMessageDialog(null, "Usuario cadastrado com sucesso");
            
        } catch (SQLException ex) {
            showMessageDialog(null, "Falha ao cadastrar usuário");
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public List<User> readUsers(){
        String sql = "SELECT * FROM users";
        
        List<User> users = new ArrayList<User>();
        
         PreparedStatement ps = null;
         //Class who recover data bases
         ResultSet rset = null;
         
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rset = ps.executeQuery();
            
            //int i =1;
            while(rset.next()){
                User user = new User();
                user.setCpf(rset.getString("cpf"));
                user.setName(rset.getString("nome"));
                user.setEmail(rset.getString("email"));
                user.setPassword(rset.getString("pass_word"));
                user.setNumber(rset.getString("celular"));
                //System.out.println(i++);
                //In each loop realized this add one student object in array: students;
                users.add(user);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(rset != null){
                     rset.close();
                }
                if(ps != null){
                     ps.close();
                }
             } catch (SQLException ex) {
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }      
            }
        return users;
    }
    
  
    public void updateUser(User person){
          String sql = "UPDATE users SET nome = ?, email = ?, pass_word = ?, celular =? WHERE cpf=? ";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getEmail());
            ps.setString(3, person.getPassword());
            ps.setString(4, person.getNumber());
            ps.setString(5, person.getCpf());
           
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(ps!=null){
                   ps.close();
                }
            }catch(SQLException ex){
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteUser(User person){
        String sql = "DELETE FROM users WHERE cpf=?";
        
        PreparedStatement ps = null;
        
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, person.getCpf());
            
            ps.execute();
        }catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(ps!=null){
                    ps.close();
                }
            }catch(SQLException ex){
                 Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);        
            }
        }
        
        
    }

    public boolean loginUser(User person){
        String sql = "SELECT * FROM users WHERE cpf=?";
        boolean isLogin = false;
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, person.getCpf());
        ResultSet rset = ps.executeQuery();
        
        
        //return the result of query realized on rset
            if(!rset.next()){
                showMessageDialog(null, "Usuário não Cadastrado");
            }else{
               String pass = rset.getString("pass_word");
               if(!person.getPassword().equals(pass)){
                   isLogin = false;
                   showMessageDialog(null, "senha Incorreta");
               }else{
                   isLogin = true;
               }
            }
       
        }catch(SQLException ex){
            System.out.println("error:");
            ex.getStackTrace();
            
         }
        
        return isLogin;
    }
    
    //TODO:
    private void passError(int passTry){
        System.out.println(passTry);
        if(passTry > 5){
        showConfirmDialog(null, "Mais de 5 tentativas invalidas, esqueceu a senha? ");
        }     
    }
}
