package DAO;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class ClipDAOTest {


    @Test
    public void testGetConn(){
        Connection conn = null;
        try {
            conn = ClipDAO.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(conn != null);
    }

}