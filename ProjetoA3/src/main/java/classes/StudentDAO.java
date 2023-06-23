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
public class StudentDAO extends Student{
    
    public void addStudent(Student person){
        String sql = "INSERT INTO student (nome, endereco, celular, email, course_key) VALUES(?,?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getAdress());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getEmail());
            ps.setInt(5, person.getCourse());
            
            ps.execute();
            ps.close();
            showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao cadastrar no banco");
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Student> readStudent(){
        String sql = "SELECT * FROM student";
        
        List<Student> students = new ArrayList<>();
        
         PreparedStatement ps = null;
         //Class who recover data bases
         ResultSet rset = null;
         
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rset = ps.executeQuery();
            
            //int i =1;
            while(rset.next()){
                Student student = new Student();
                student.setRa(rset.getString("ra"));
                student.setName(rset.getString("nome"));
                student.setAdress(rset.getString("endereco"));
                student.setPhone(rset.getString("celular"));
                student.setEmail(rset.getString("email"));
                student.setCourse(rset.getInt("course_key"));
                
                //In each loop realized this add one student object in array: students;
                students.add(student);
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
        return students;
    }
    
    public void updateStudent(Student person){
          String sql = "UPDATE student SET nome = ?, endereco = ?, celular = ?, email = ?, course_key =? WHERE ra=? ";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getAdress());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getEmail());
            ps.setInt(5, person.getCourse());
            ps.setString(6, person.getRa());
            
            ps.execute();
            showMessageDialog(null, "atualizado com sucesso");
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao atualizar no banco");
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
    
    public void deleteStudent(Student person){
        String sql = "DELETE FROM student WHERE ra=?";
        
        PreparedStatement ps = null;
        
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, person.getRa());
            
            ps.execute();
            showMessageDialog(null, "Deletado com sucesso");
        }catch(SQLException ex){
            showMessageDialog(null, "Erro ao deletar do banco");
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

}