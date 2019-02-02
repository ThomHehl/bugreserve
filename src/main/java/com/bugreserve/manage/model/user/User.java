package com.bugreserve.manage.model.user;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column
    private String userName;

}
