package com.bugreserve.manage.model.issue;

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
@Entity(name="issue_comment")
public class IssueComment {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "issue_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Issue issue;

    @Column(nullable = false)
    @Lob
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar startDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getStartDate() {
        return DateHelper.toLocalDateTime(startDate);
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = DateHelper.toCalendar(startDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof IssueComment)) {
            return false;
        }

        IssueComment that = (IssueComment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(issue, that.issue) &&
                Objects.equals(text, that.text) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, issue, text, startDate);
    }
}
