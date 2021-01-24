package org.example.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.Absences;
import org.example.Model.AffichageStudent;
import org.example.Model.Apprenant;
import org.example.MysqlConnect.Connexion;
import java.sql.*;
import java.util.Objects;

public  class FormateurDaoImp extends Connexion implements FormateurDao{

    Statement statement=null;

    @Override
    public ResultSet get_By_id(int id) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }

    @Override
    public String setApprenent(Apprenant apprenant) throws SQLException {
        return null;
    }

    @Override
    public String setAbsence(Absences absences) throws SQLException {
        return null;
    }

    @Override
    public String setFormateur(String email, String password) throws SQLException {
        return null;
    }

    @Override
    public String updateFormateur(String email, String password) throws SQLException {
        return null;
    }

    @Override
    public ObservableList<AffichageStudent> AfficheStudentName() {
        ObservableList<AffichageStudent> AbsenceStudents= FXCollections.observableArrayList();
        Connection conn = null;
        try {
            String requete= "SELECT full_name FROM users,students WHERE users.id=students.user_id AND type=\"student\"";
            PreparedStatement statement = Objects.requireNonNull(connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            AffichageStudent affichageStudent;
            while (rs.next()) {
                affichageStudent = new  AffichageStudent(rs.getString("full_name"));
                AbsenceStudents.add(affichageStudent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (conn  != null) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return AbsenceStudents;
    }
}


   /*@Override
    public ResultSet get_By_id(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM `Teachers` WHERE id  = ?;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1,id);
            return stmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        try {
            Statement stmt = Objects.requireNonNull(connect()).createStatement();
            return stmt.executeQuery("SELECT * FROM Teachers");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }


    @Override
    public String setApprenent(Apprenant apprenant) throws SQLException {
        try {
            var sql = "SELECT `full_name` FROM `users`,`classes`,`students`WHERE `users.id=students.user_id` And `students.classe_id=classes.id` And type=`students`VALUES(?,?,?);";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setString(1, apprenant.getFull_name());
            stmt.setInt(1, apprenant.getClass_id());
            stmt.setInt(1, apprenant.getUser_id());
            stmt.executeUpdate();
            return "Done!";
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                connect().close();
            }
        }
    }

   @Override
    public String setFormateur(Formateur formateur) throws SQLException {
        try {
            var sql = "INSERT INTO `Users` (`email`, `password`) VALUES(?,?)";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, Formateur.getUser_id());
            stmt.setInt(2, Formateur.getClass_id());
            stmt.executeUpdate();
            return "Done!";
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                connect().close();
            }
        }
    }


    @Override
    public String updateFormateur(Formateur formateur) throws SQLException {
        try {
            var sql = "UPDATE Users SET `email`, `password` = ? VALUES(?,?) ";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setString(1, formateur.getEmail());
            stmt.setString(2, formateur.getPassword());
            stmt.executeUpdate();
            return "Done!";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                Objects.requireNonNull(connect()).close();
            }
        }
    }
*/

