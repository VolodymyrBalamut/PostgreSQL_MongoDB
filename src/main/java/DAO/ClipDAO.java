package DAO;
import Model.Clip;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClipDAO implements IDAO<Clip> {


    public static Connection getConnection() throws Exception {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return null;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/MusicHub", "postgres",
                    "123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
            return connection;
        } else {
            System.out.println("Failed to make connection!");
            return null;
        }
    }

    @Override
    public List<Clip> findAll() {
        List<Clip> clips = new ArrayList<Clip>();

        return null;
    }

    @Override
    public List<Clip> findById(int id) {
        return null;
    }

    @Override
    public List<Clip> findByName(String name) {
        return null;
    }

    @Override
    public boolean insert(Clip obj){
        //Get connection with DB
        try (Connection conn = ClipDAO.getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Insert into clips " +
                            "(name, url, performer_id, style_id) " +
                            "values ( ?, ?, ?, ?)");

            //Set values of parameters
            //st.setInt(1, obj.getId());
            st.setString(1, obj.getName());
            st.setString(2, obj.getUrl());
            st.setInt(3, obj.getPerformer_id());
            st.setInt(4, obj.getStyle_id());

            //Execute query
            st.executeUpdate();

            //Close conn
            conn.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Clip obj) {
        //Get connection with DB
        try (Connection conn = ClipDAO.getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Update clips " +
                            "Set name = ?, url =?, performer_id = ?, style_id = ? " +
                            "Where id = ?");

            //Set values of parameters
            st.setString(1, obj.getName());
            st.setString(2, obj.getUrl());
            st.setInt(3, obj.getPerformer_id());
            st.setInt(4, obj.getStyle_id());
            st.setInt(5, obj.getId());

            //Execute query
            st.executeUpdate();

            //Close conn
            conn.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Clip obj) {
        //Get connection with DB
        try (Connection conn = ClipDAO.getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Delete from clips " +
                            "Where id = ?");

            //Set values of parameters
            st.setInt(1, obj.getId());

            //Execute query
            st.executeUpdate();

            //Close conn
            conn.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
}
