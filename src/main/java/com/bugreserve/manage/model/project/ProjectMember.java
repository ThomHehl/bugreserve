package com.bugreserve.manage.model.project;

import com.bugreserve.manage.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heavyweightsoftware.util.DateHelper;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

@Table
@Entity(name="project_member")
public class ProjectMember {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @JoinColumn(name = "project_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Project project;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar start;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date", nullable = false)
    private Calendar end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDateTime getStart() {
        return DateHelper.toLocalDateTime(start);
    }

    public void setStart(LocalDateTime start) {
        this.start = DateHelper.toCalendar(start);
    }

    public LocalDateTime getEnd() {
        return DateHelper.toLocalDateTime(end);
    }

    public void setEnd(LocalDateTime end) {
        this.end = DateHelper.toCalendar(end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ProjectMember)) {
            return false;
        }

        ProjectMember that = (ProjectMember) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(project, that.project) &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, project, start, end);
    }
}
