package itsol.nguyenbanh.demospringsecurity.entities;


import javax.persistence.*;

@Entity
@Table(name = "STAFF_ROLE")
public class Staff_Role {


    @Column(name = "STAFF_ROLE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "STAFF_ROLE_DESCIPTION")
    private String description;


    @ManyToOne
    @JoinColumn(name = "STAFF_ID")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
