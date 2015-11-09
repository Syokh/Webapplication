package education.spring.java.lesson.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class UserRole extends Model {

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> user = new HashSet<User>();

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private ListRole listRole;

    public UserRole() {
        super();
    }
    public UserRole(long id) {
        super(id);
    }

    public ListRole getListRole() {
        return listRole;
    }

    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
