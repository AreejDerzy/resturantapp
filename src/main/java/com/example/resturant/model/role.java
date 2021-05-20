package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="role")
public class role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    public int getroleId() {
        return roleId;
    }

    public void setroleId(int roleId) {
        this.roleId = roleId;
    }
    ////////////////////////////////////////////

    @Column(name = "type")
    private String type;

    public String gettype() { return type; }

    public void settype(String type) { this.type  = type; }
    ////////////////////////////////////////////

}
