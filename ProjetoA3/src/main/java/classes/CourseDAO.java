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
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Marco
 */
public class CourseDAO extends Courses{
    
     public void addCourse(Courses course){
        String sql = "INSERT INTO courses (course_id, nome, professor, descricao) VALUES(?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getNameCourse());
            ps.setString(3, course.getTeacher());
            ps.setString(4, course.getDescription());
            
            ps.execute();
            ps.close();
            showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao cadastrar no banco");
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public List<Courses> readCourses(){
        String sql = "SELECT * FROM courses";
        
        List<Courses> courseList = new ArrayList<>();
        
         PreparedStatement ps = null;
         //Class who recover data bases
         ResultSet rset = null;
         
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rset = ps.executeQuery();
            
           
            while(rset.next()){
                Courses course = new Courses();
                course.setCourseID(rset.getString("course_id"));
                course.setCourseName(rset.getString("nome"));
                course.setTeacher(rset.getString("professor"));
                course.setDescription(rset.getString("descricao"));
                //System.out.println(i++);
                //In each loop realized this add one student object in array: students;
                courseList.add(course);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            showMessageDialog(null, "Erro ao requisitar informações do banco");
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
        return courseList;
    }
     
       public void updateCourse(Courses course){
          String sql = "UPDATE courses SET nome = ?, professor= ?, descricao=? WHERE course_id=? ";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, course.getNameCourse());
            ps.setString(2, course.getTeacher());
            ps.setString(3, course.getDescription());
            ps.setString(4, course.getCourseID());
            
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
       
     public void deleteCourse(Courses course){
        String sql = "DELETE FROM courses WHERE course_id=?";
        
        PreparedStatement ps = null;
        
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            
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
