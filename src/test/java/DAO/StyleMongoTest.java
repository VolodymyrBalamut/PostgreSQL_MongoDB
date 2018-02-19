package DAO;

import Model.Style;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class StyleMongoTest {

    public StyleMongo styleMongo;

    public StyleMongoTest(){
        styleMongo = new StyleMongo();
    }

    @Test
    public void getCollection() {
        MongoCollection<Document> coll = StyleMongo.getCollection();
        assertTrue((coll != null ? true : false) == true);
    }

    @Test
    public void findAll() {
        List<Style> styles = styleMongo.findAll();
        styles.forEach(System.out::println);
    }

    @Test
    public void findById() {
        List<Style> styles = styleMongo.findById(5);
        styles.forEach(System.out::println);
    }

    @Test
    public void findByName() {
        List<Style> styles = styleMongo.findByName("Art");
        styles.forEach(System.out::println);
    }

    @Test
    public void insert() {
        Style style = new Style(5,"Pop","cool");
        assertTrue(styleMongo.insert(style) == true);
    }

    @Test
    public void update() {
        Style style = new Style(2,"ArtS","cool");
        assertTrue(styleMongo.update(style) == true);
    }

    @Test
    public void delete() {
        Style style = new Style(5,"ArtS","cool");
        assertTrue(styleMongo.delete(style) == true);
    }
}