package com.bugreserve.manage.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heavyweightsoftware.util.DateHelper;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

@Table
@Entity(name="group_member")
public class GroupMember implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name = "user_group", nullable = false)
    private UserGroup userGroup;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", nullable = false)
    @CreatedDate
    private Calendar startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date")
    private Calendar endDate;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return DateHelper.toLocalDateTime(startDate);
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = DateHelper.toCalendar(startDate);
    }

    public LocalDateTime getEndDate() {
        return DateHelper.toLocalDateTime(endDate);
    }

    public void setEndDate() {
        this.endDate = new GregorianCalendar();
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = DateHelper.toCalendar(endDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof GroupMember)) {
            return false;
        }
        GroupMember that = (GroupMember) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userGroup, that.userGroup) &&
                Objects.equals(user, that.user) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userGroup, user, startDate, endDate);
    }
}
