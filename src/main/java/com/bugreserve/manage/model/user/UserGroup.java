package com.bugreserve.manage.model.user;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="user_group")
public class UserGroup implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

}
