package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="client")
public class client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;

    public int getclientId() {
        return clientId;
    }

    public void setclientId(int clientId) {
        this.clientId = clientId;
    }
    ////////////////////////////////////////////

    @Column(name = "client_name")
    private String clientName;

    public String getclientName() {
        return clientName;
    }

    public void setclientName(String clientName) {
        this.clientName = clientName;
    }
    ////////////////////////////////////////////

    @Column(name = "client_email")
    private String clientEmail;

    public String getclientEmail() {
        return clientEmail;
    }

    public void setclientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    ////////////////////////////////////////////

    @Column(name = "client_address")
    private String clientAddress;

    public String getclientAddress() {
        return clientAddress;
    }

    public void setclientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
    ////////////////////////////////////////////

    @Column(name = "client_password")
    private String clientPassword;

    public String getclientPassword() {
        return clientPassword;
    }

    public void setclientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }
    ////////////////////////////////////////////

}
