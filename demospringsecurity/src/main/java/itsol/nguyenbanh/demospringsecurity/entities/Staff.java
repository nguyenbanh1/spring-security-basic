package itsol.nguyenbanh.demospringsecurity.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STAFF_ID")
    private int id;

    @Column(name = "STAFF_USERNAME")
    private String username;

    @Column(name = "STAFF_PASSWORD")
    private String password;

    @Column(name = "STAFF_ENABLED")
    private boolean enabled = true;

    @OneToMany(mappedBy = "staff")
    private List<Staff_Role> staff_roles= new ArrayList<Staff_Role>();

    public List<Staff_Role> getStaff_roles() {
        return staff_roles;
    }

    public void setStaff_roles(List<Staff_Role> staff_roles) {
        this.staff_roles = staff_roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
