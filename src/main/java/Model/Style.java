package Model;

import java.util.Objects;


public class Style {
    private int id;
    private String name;
    private String description;


    public Style(){ }
    public Style(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

        @Override
    public String toString() {
        return "Style{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Style)) return false;
        Style style = (Style) o;
        return getId() == style.getId() &&
                Objects.equals(getName(), style.getName()) &&
                Objects.equals(getDescription(), style.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDescription());
    }
}

