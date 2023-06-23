/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import classes.Student;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author Marco
 */
public class StudentScreen extends javax.swing.JFrame {
    
    DefaultTableModel table;
    private Student aluno = new Student();
    public List<Student> listaAlunos = new ArrayList<>();
    
    public StudentScreen() {
        initComponents();
        readTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();
        btnAtualizarAluno = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCadastrarAluno = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        barHome = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Aluno");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Aluno");

        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RA", "NOME", "ENDEREÇO", "CELULAR", "EMAIL", "CURSO"
            }
        ));
        tblAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlunosMouseClicked(evt);
            }
        });
        tblAlunos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblAlunosComponentShown(evt);
            }
        });
        tblAlunos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAlunosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAlunosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblAlunosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlunos);

        btnAtualizarAluno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizarAluno.setText("Atualizar");
        btnAtualizarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarAlunoActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCadastrarAluno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrarAluno.setText("Adicionar Aluno");
        btnCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAlunoActionPerformed(evt);
            }
        });

        barHome.setText("Home");
        barHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barHomeMouseClicked(evt);
            }
        });
        barHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barHomeActionPerformed(evt);
            }
        });
        jMenuBar1.add(barHome);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizarAluno)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnAtualizarAluno))
                    .addComponent(btnCadastrarAluno))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAlunosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblAlunosComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAlunosComponentShown

    private void tblAlunosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlunosKeyReleased
        // TODO add your handling code here:
        if(tblAlunos.getSelectedRow() != -1){
            Student alunoListado = new Student();
            int rowLength = tblAlunos.getColumnCount();
            
            for(int i = 0; i < rowLength; i++){
            Object data = tblAlunos.getValueAt(tblAlunos.getSelectedRow(), i);
            switch(i){
                case 0:
                    if(!data.equals("")){
                      aluno.setRa(data.toString());
                      alunoListado.setRa(data.toString());
                    }else{
                        aluno.setRa(null);
                        alunoListado.setRa(null);
                    }
                    break;
                    
                case 1:
                    if(!data.equals("")){
                        aluno.setName(data.toString());
                        alunoListado.setName(data.toString());
                    }else{
                        showMessageDialog(null, "Insira o nome para continuar");
                    }
                    break;
                    
                case 2: 
                    aluno.setAdress(data.toString());
                    alunoListado.setAdress(data.toString());
                    break;
                    
                case 3: 
                    if(!data.equals("")){
                        aluno.setPhone(data.toString());
                        alunoListado.setPhone(data.toString());
                    }else{
                        showMessageDialog(null, "Insira um telefone de contato para continuar");
                    }
                    break;
                    
                case 4: 
                    aluno.setEmail(data.toString());
                    alunoListado.setEmail(data.toString());
                    break;
                    
                case 5:
                    if(!data.equals("")){
                       aluno.setCourse(Integer.parseInt(data.toString())); 
                       alunoListado.setCourse(Integer.parseInt(data.toString())); 
                    }else{
                        showMessageDialog(null, "Você deve digitar o curso referente ao aluno");
                    }
                break;
                
                default:
                    showMessageDialog(null,"Error dado de aluno esperado" );
                    break;
                }
            }
            listaAlunos.add(alunoListado);
        }
    }//GEN-LAST:event_tblAlunosKeyReleased

    private void tblAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMouseClicked
        // TODO add your handling code here:
        if(tblAlunos.getSelectedRow() != -1){
            Object selectedRa = tblAlunos.getValueAt(tblAlunos.getSelectedRow(), 0);
            aluno.setRa(selectedRa.toString());
        }
    }//GEN-LAST:event_tblAlunosMouseClicked

    private void btnCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAlunoActionPerformed
        // TODO add your handling code here:
       new TelaCadastroAluno().setVisible(true);
    }//GEN-LAST:event_btnCadastrarAlunoActionPerformed

    private void tblAlunosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlunosKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblAlunosKeyPressed

    private void tblAlunosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlunosKeyTyped
        // TODO add your handling code here:
         
    }//GEN-LAST:event_tblAlunosKeyTyped

    private void btnAtualizarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarAlunoActionPerformed
        // TODO add your handling code here:
        Connection conexao = Conexao.getConexao();
        try{
            String sql = "Select * from student";
            PreparedStatement ps = conexao.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY );
            ResultSet resultado = ps.executeQuery();
            resultado.first();
            int ra = resultado.getInt("ra");
            String nome = resultado.getString("nome");
            String endereco = resultado.getString("endereco");
            String celular = resultado.getString("celular");
            String email = resultado.getString("email");
            String cursos = resultado.getString("cursos");
            conexao.close();
            DefaultTableModel tblModeloPadrao = (DefaultTableModel) tblAlunos.getModel();
            tblModeloPadrao.setRowCount(1);
            tblModeloPadrao.addRow(
                    new Object[] {ra, nome, endereco, celular, email, cursos}
            );
        } catch (SQLException ex) {
            Logger.getLogger(StudentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtualizarAlunoActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void barHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barHomeActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_barHomeActionPerformed

    private void barHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barHomeMouseClicked
        // TODO add your handling code here:
        dispose();
        TelaMenu menu = new TelaMenu();
        menu.setVisible(true);
        menu.setExtendedState(TelaMenu.MAXIMIZED_BOTH);
    }//GEN-LAST:event_barHomeMouseClicked
    
    public boolean verifyVoidRows(){
        boolean teste = true;
        int rowLength = tblAlunos.getColumnCount();
            
            for(int i = 0; i < rowLength; i++){
            Object collum = tblAlunos.getValueAt(tblAlunos.getSelectedRow(), i);
            switch(i){
                case 1:
                    if(collum.equals("")){
                       showMessageDialog(null, "Insira o nome para continuar");
                       teste = false;
                    }
                    break;
                    
                case 3: 
                    if(collum.equals("")){
                       showMessageDialog(null, "Insira um telefone de contato para continuar");
                       teste = false;
                    }
                    break;
                    
                case 5:
                    if(collum.equals("")){
                        showMessageDialog(null, "Você deve digitar o curso referente ao aluno");
                        teste = false;
                    }
                break;
                }
            }
            return teste;
            
    }
    
    public void readTable(){
       /* this.table = (DefaultTableModel) studentTable.getModel();
        table.setNumRows(0);
        StudentDAO student = new StudentDAO();
        List<Student> students = student.readStudent();
        for(Student element : students){
            table.addRow( new Object[]{
                element.getRa(),
                element.getName(),
                element.getAdress(),
                element.getPhone(),
                element.getEmail(),
                element.getCourse()
            });
        } */
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu barHome;
    private javax.swing.JButton btnAtualizarAluno;
    private javax.swing.JButton btnCadastrarAluno;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlunos;
    // End of variables declaration//GEN-END:variables
}