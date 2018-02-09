package DAO;

import Model.Clip;
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

    @Test
    public void testInsert(){
        Clip clip = new Clip(1,"Barking","fdfdfs",1,1);
        ClipDAO clipDAO = new ClipDAO();
        assertTrue(clipDAO.insert(clip) == true);
    }

    @Test
    public void testUpdate(){
        Clip clip = new Clip(1,"BarkingU","fdfdfs",1,1);
        ClipDAO clipDAO = new ClipDAO();
        assertTrue(clipDAO.update(clip) == true);
    }
    @Test
    public void testDelete(){
        Clip clip = new Clip(1,"BarkingU","fdfdfs",1,1);
        ClipDAO clipDAO = new ClipDAO();
        assertTrue(clipDAO.delete(clip) == true);
    }

}