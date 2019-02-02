package com.bugreserve.manage.model.project;

import com.bugreserve.manage.model.user.UserGroup;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="project_group")
public class ProjectGroup implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private UserGroup userGroup;

    @Column(nullable = false)
    private String name;

}
