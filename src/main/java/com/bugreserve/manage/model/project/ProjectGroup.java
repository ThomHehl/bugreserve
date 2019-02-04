package com.bugreserve.manage.model.project;

import com.bugreserve.manage.model.user.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity(name="project_group")
public class ProjectGroup implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "user_group_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserGroup userGroup;

    @JoinColumn(name = "project_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Project project;

    @Column(nullable = false)
    private String name;

    @Column(name="role_type")
    @Enumerated(EnumType.STRING)
    private RoleType RoleType;
}
