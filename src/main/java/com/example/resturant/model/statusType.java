package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="status_type")
public class statusType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statusTypeId;

    public int getstatusTypeId() {
        return statusTypeId;
    }

    public void setstatusTypeId(int statusTypeId) {
        this.statusTypeId = statusTypeId;
    }
    ////////////////////////////////////////////

    @Column(name = "status_type_name")
    private String statusTypeName;

    public String getstatusTypeName() { return statusTypeName; }

    public void setstatusTypeName(String statusTypeName) { this.statusTypeName  = statusTypeName; }
    ////////////////////////////////////////////
}
