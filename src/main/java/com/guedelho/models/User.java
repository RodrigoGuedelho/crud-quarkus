package com.guedelho.models;

import com.guedelho.enuns.GenericStatus;



import javax.persistence.*;
import java.util.Objects;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
@Table(name = "users")
public class User extends PanacheEntity {
    @Column(length = 70)
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private GenericStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenericStatus getStatus() {
        return status;
    }

    public void setStatus(GenericStatus status) {
        this.status = status;
    }
}
