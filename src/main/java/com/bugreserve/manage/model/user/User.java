package com.bugreserve.manage.model.user;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Table
@Entity(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable = false)
    @CreatedDate
    private Calendar created;
}
