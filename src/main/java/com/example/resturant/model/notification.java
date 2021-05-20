package com.example.resturant.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="notification")
public class notification implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int notificationId;

    public int getnotificationId() {
        return notificationId;
    }

    public void setnotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
    ////////////////////////////////////////////

    @Column(name = "content")
    private String content;

    public String getcontent() {
        return content  ;
    }

    public void setcontent(String content  ) {
        this.content   = content;
    }
    ////////////////////////////////////////////

    @Column(name = "time_notification")
    private LocalDateTime timeNotification;

    public LocalDateTime gettimeNotification () {
        return timeNotification;
    }

    public void settimeNotification (LocalDateTime timeNotification   ) {
        this.timeNotification= timeNotification;
    }
    ////////////////////////////////////////////

    @Column(name = "client_id")
    private int client_id;

    public int getclient_id() {
        return client_id;
    }

    public void setclient_id(int client_id) {
        this.client_id= client_id;
    }
    /////////////////////////////////////////////


}
