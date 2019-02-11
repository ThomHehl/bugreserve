package com.bugreserve.manage.model.user;

import com.bugreserve.manage.model.issue.Issue;
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
@Entity(name="notification")
public class Notification implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date", nullable = false)
    @CreatedDate
    private Calendar creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="notified_date")
    private Calendar notifiedDate;

    @JoinColumn(name = "issue_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Issue issue;

    @Column(nullable = false)
    @Lob
    private String text;

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

    public LocalDateTime getCreationDate() {
        return DateHelper.toLocalDateTime(creationDate);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = DateHelper.toCalendar(creationDate);
    }

    public LocalDateTime getNotifiedDate() {
        return DateHelper.toLocalDateTime(notifiedDate);
    }

    public void setNotifiedDate(LocalDateTime notifiedDate) {
        this.notifiedDate = DateHelper.toCalendar(notifiedDate);
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Notification)) {
            return false;
        }

        Notification that = (Notification) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(notifiedDate, that.notifiedDate) &&
                Objects.equals(issue, that.issue) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, creationDate, notifiedDate, issue, text);
    }
}
