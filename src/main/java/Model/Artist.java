package Model;

import javax.xml.crypto.Data;
import java.util.Objects;

public class Artist
{
    private int id;
    private String name;
    private String biography;
    private int id_country;

    public Artist(int id, String name, String biography, int id_country)
    {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.id_country = id_country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }
}
