package DAO.PostgreSQL;
import DAO.IDAO;
import domain.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


import static Connection.PostgreSQLConn.getConnection;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class CountryDAO implements IDAO<Country> {

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<Country>();
        //Get connection with DB
        try (Connection conn = getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Select * from countries ");

            //Execute query
            ResultSet rs = st.executeQuery();

            Country country = null;
            while (rs.next()) {
                country = new Country(
                        rs.getString(1),
                        rs.getString(2));
                countries.add(country);
            }
            rs.close();
            conn.close();
            LOGGER.log(Level.INFO,"Method findAll() was executed successfully!");
            return countries;
        }
        catch(SQLException sqlex){
            LOGGER.log(Level.WARNING,"SQLException: ",sqlex);
            return null;
        }
        catch (Exception ex){
            LOGGER.log(Level.WARNING,"Exception: ",ex);
            return null;
        }
    }

    @Override
    public List<Country> findById(int id) {
        List<Country> countries = new ArrayList<Country>();
        //Get connection with DB
        try (Connection conn = getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Select * from countries "+
                            "Where country_code = ?");
            //Set values of parameters
            st.setInt(1, id);
            //Execute query
            ResultSet rs = st.executeQuery();

            Country country = null;
            while (rs.next()) {
                country = new Country(
                        rs.getString(1),
                        rs.getString(2));
                countries.add(country);
            }
            rs.close();
            conn.close();
            LOGGER.log(Level.INFO,"Method findById() was executed successfully!");
            return countries;
        }
        catch(SQLException sqlex){
            LOGGER.log(Level.WARNING,"SQLException: ",sqlex);
            return null;
        }
        catch (Exception ex){
            LOGGER.log(Level.WARNING,"Exception: ",ex);
            return null;
        }
    }

    @Override
    public List<Country> findByName(String name) {
        List<Country> countries = new ArrayList<Country>();
        //Get connection with DB
        try (Connection conn = getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Select * from countries "+
                            "Where country_name = ?");

            //Set values of parameters
            st.setString(1, name);
            //Execute query
            ResultSet rs = st.executeQuery();

            Country country = null;
            while (rs.next()) {
                country = new Country(
                        rs.getString(1),
                        rs.getString(2));
                countries.add(country);
            }
            rs.close();
            conn.close();
            LOGGER.log(Level.INFO,"Method findByName() was executed successfully!");
            return countries;
        }
        catch(SQLException sqlex){
            LOGGER.log(Level.WARNING,"SQLException: ",sqlex);
            return null;
        }
        catch (Exception ex){
            LOGGER.log(Level.WARNING,"Exception: ",ex);
            return null;
        }
    }

    @Override
    public boolean insert(Country obj){
        //Get connection with DB
        try (Connection conn = getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Insert into countries " +
                            "(country_code,country_name) " +
                            "values ( ?, ?)");

            //Set values of parameters
            //st.setInt(1, obj.getId());
            st.setString(1, obj.getCountry_code());
            st.setString(2, obj.getCountry_name());

            //Execute query
            st.executeUpdate();

            //Close conn
            conn.close();
        }
        catch(SQLException sqlex){
            LOGGER.log(Level.WARNING,"SQLException: ",sqlex);
            return false;
        }
        catch (Exception ex){
            LOGGER.log(Level.WARNING,"Exception: ",ex);
            return false;
        }
        LOGGER.log(Level.INFO,"Method insert() was executed successfully!");
        return true;
    }

    @Override
    public boolean update(Country obj) {
        //Get connection with DB
        try (Connection conn = getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Update countries " +
                            "Set country_name = ? " +
                            "Where country_code = ?");

            //Set values of parameters
            st.setString(1, obj.getCountry_name());
            st.setString(2, obj.getCountry_code());


            //Execute query
            st.executeUpdate();

            //Close conn
            conn.close();
        }
        catch(SQLException sqlex){
            LOGGER.log(Level.WARNING,"SQLException: ",sqlex);
            return false;
        }
        catch (Exception ex){
            LOGGER.log(Level.WARNING,"Exception: ",ex);
            return false;
        }
        LOGGER.log(Level.INFO,"Method update() was executed successfully!");
        return true;
    }

    @Override
    public boolean delete(Country obj) {
        //Get connection with DB
        try (Connection conn = getConnection()) {
            //Prepared sql statement
            PreparedStatement st = conn.prepareStatement(
                    "Delete from countries " +
                            "Where country_code = ?");

            //Set values of parameters
            st.setString(1, obj.getCountry_code());

            //Execute query
            st.executeUpdate();

            //Close conn
            conn.close();
        }
        catch(SQLException sqlex){
            LOGGER.log(Level.WARNING,"SQLException: ",sqlex);
            return false;
        }
        catch (Exception ex){
            LOGGER.log(Level.WARNING,"Exception: ",ex);
            return false;
        }
        LOGGER.log(Level.INFO,"Method delete() was executed successfully!");
        return true;
    }
}

