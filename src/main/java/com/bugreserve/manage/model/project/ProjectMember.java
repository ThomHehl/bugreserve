package com.bugreserve.manage.model.project;

import javax.persistence.*;

@Table
@Entity(name="project_member")
public class ProjectMember {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name="user_name", nullable = false)
    private String userName;
}
