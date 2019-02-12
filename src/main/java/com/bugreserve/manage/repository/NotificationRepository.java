package com.bugreserve.manage.repository;

import com.bugreserve.manage.model.user.Notification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

    List<Notification> findByUser_UserNameAndNotifiedDateIsNull(String userName);
}
