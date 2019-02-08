package com.bugreserve.manage.model.project;

import com.bugreserve.manage.model.user.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.bugreserve.manage.model.project.RoleType getRoleType() {
        return RoleType;
    }

    public void setRoleType(com.bugreserve.manage.model.project.RoleType roleType) {
        RoleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ProjectGroup)) {
            return false;
        }

        ProjectGroup that = (ProjectGroup) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userGroup, that.userGroup) &&
                Objects.equals(project, that.project) &&
                Objects.equals(name, that.name) &&
                RoleType == that.RoleType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userGroup, project, name, RoleType);
    }
}
