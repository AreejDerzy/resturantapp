package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="questionnaire")
public class questionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionnaireId;

    public int getquestionnaireId() { return questionnaireId; }

    public void setquestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    ////////////////////////////////////////////

    @Column(name = "content")
    private String content;

    public String getcontent() { return content; }

    public void setcontent(String content) { this.content  = content ; }
    ////////////////////////////////////////////

    @Column(name = "client_id")
    private int clientId;

    public int getclientId() { return clientId; }

    public void setclientId(int clientId) { this.clientId  = clientId; }

}
