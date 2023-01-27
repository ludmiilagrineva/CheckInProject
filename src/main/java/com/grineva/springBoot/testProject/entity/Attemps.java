package com.grineva.springBoot.testProject.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attemps")
public class Attemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int attemp;
    private Date lastAttemp;

    public Attemps() {
    }

    public Attemps(String username, int attemp, Date lastAttemp) {
        this.username = username;
        this.attemp = attemp;
        this.lastAttemp = lastAttemp;
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

    public int getAttemp() {
        return attemp;
    }

    public void setAttemp(int attemp) {
        this.attemp = attemp;
    }

    public Date getLastAttemp() {
        return lastAttemp;
    }

    public void setLastAttemp(Date lastAttemp) {
        this.lastAttemp = lastAttemp;
    }
}
