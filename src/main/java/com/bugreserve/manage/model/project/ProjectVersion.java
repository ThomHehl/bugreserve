package com.bugreserve.manage.model.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heavyweightsoftware.util.DateHelper;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

@Table
@Entity(name="project_version")
public class ProjectVersion implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "project_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Project project;

    @Column()
    private String name;

    @Column(nullable = false)
    private String versionNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @CreatedDate
    private Calendar createDate;

    @Column()
    private Calendar dueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return DateHelper.toLocalDateTime(createDate);
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = DateHelper.toCalendar(createDate);
    }

    public LocalDateTime getDueDate() {
        return DateHelper.toLocalDateTime(dueDate);
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = DateHelper.toCalendar(dueDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ProjectVersion)) {
            return false;
        }

        ProjectVersion that = (ProjectVersion) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(project, that.project) &&
                Objects.equals(name, that.name) &&
                Objects.equals(versionNumber, that.versionNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, project, name, versionNumber, description, createDate, dueDate);
    }
}
