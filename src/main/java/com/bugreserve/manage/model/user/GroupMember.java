package com.bugreserve.manage.model.user;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="group_member")
public class GroupMember implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name = "user_group")
    private UserGroup userGroup;

    @Column()
    private User user;

}
