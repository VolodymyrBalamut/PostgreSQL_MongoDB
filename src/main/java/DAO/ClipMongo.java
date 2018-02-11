package DAO;

import Model.Clip;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ClipMongo implements IDAO<Clip> {


    public static MongoCollection<Document> logsCollection;

    public static void getCollection(){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("MusicHub");
        MongoCollection<Document> collection = database.getCollection("clips");
        logsCollection = collection;
    }

    @Override
    public List<Clip> findAll() {
        List<Clip> list = new ArrayList<>();
        FindIterable<Document> coll = logsCollection.find();
        for(Document doc : coll){
            Clip clip = new Clip();
            clip.setId(doc.getInteger("id"));
            clip.setName(doc.getString("name"));
            clip.setUrl(doc.getString("url"));
            clip.setStyle_id(doc.getInteger("style_id"));
            clip.setPerformer_id(doc.getInteger("performer_id"));
            list.add(clip);
        }
        return list;
    }

    @Override
    public List<Clip> findById(int id) {
        List<Clip> list = new ArrayList<>();
        FindIterable<Document> coll = logsCollection.find(eq("id", id));
        for(Document doc : coll){
            Clip clip = new Clip();
            clip.setId(doc.getInteger("id"));
            clip.setName(doc.getString("name"));
            clip.setUrl(doc.getString("url"));
            clip.setStyle_id(doc.getInteger("style_id"));
            clip.setPerformer_id(doc.getInteger("performer_id"));
            list.add(clip);
        }
        return list;
    }

    @Override
    public List<Clip> findByName(String name) {
        List<Clip> list = new ArrayList<>();
        FindIterable<Document> coll = logsCollection.find(eq("name", name));
        for(Document doc : coll){
            Clip clip = new Clip();
            clip.setId(doc.getInteger("id"));
            clip.setName(doc.getString("name"));
            clip.setUrl(doc.getString("url"));
            clip.setStyle_id(doc.getInteger("style_id"));
            clip.setPerformer_id(doc.getInteger("performer_id"));
            list.add(clip);
        }
        return list;
    }

    @Override
    public boolean insert(Clip obj) {
        try {
            Document doc = new Document("id", obj.getId())
                    .append("name", obj.getName())
                    .append("url",obj.getUrl())
                    .append("performer_id",obj.getPerformer_id())
                    .append("style_id",obj.getStyle_id());
            logsCollection.insertOne(doc);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Clip obj) {
        try {
            Document doc = new Document("id", obj.getId())
                    .append("name", obj.getName())
                    .append("url",obj.getUrl())
                    .append("performer_id",obj.getPerformer_id())
                    .append("style_id",obj.getStyle_id());
            logsCollection.updateOne(eq("id", obj.getId()), new Document("$set", doc));;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Clip obj) {
        Document doc = logsCollection.find(eq("id", obj.getId())).first();
        if(!doc.isEmpty()) {
            logsCollection.deleteOne(doc);
            return true;
        }
        return false;
    }
}
