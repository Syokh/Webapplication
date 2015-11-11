package education.spring.java.lesson.model;

import javax.persistence.Entity;



@Entity
public class Book extends Model {

    private String title;
    private String description;
    private int isbm;

    public Book() {
        super();

    }

    public Book(long id){
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsbm() {
        return isbm;
    }

    public void setIsbm(int isbm) {
        this.isbm = isbm;
    }
}
