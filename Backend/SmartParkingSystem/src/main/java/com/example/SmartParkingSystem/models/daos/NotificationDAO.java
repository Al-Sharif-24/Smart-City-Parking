package com.example.SmartParkingSystem.models.daos;

import com.example.SmartParkingSystem.models.entities.Notification;
import com.example.SmartParkingSystem.models.enums.NotificationPriority;
import com.example.SmartParkingSystem.models.enums.NotificationStatus;
import com.example.SmartParkingSystem.models.enums.NotificationType;
import com.example.SmartParkingSystem.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NotificationDAO implements NotificationRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Notification> ROW_MAPPER = (rs, rowNum) -> Notification.builder()
            .id(rs.getInt("id"))
            .driverId(rs.getInt("driver_id"))
            .message(rs.getString("message"))
            .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
            .priority(NotificationPriority.valueOf(rs.getString("priority")))
            .status(NotificationStatus.valueOf(rs.getString("status")))
            .type(NotificationType.valueOf(rs.getString("type")))
            .build();

    @Override
    public void createNotification(Notification notification) {

        String query =
                "INSERT INTO notifications (driver_id, message, priority, type,status) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(query, notification.getDriverId(), notification.getMessage(),
                notification.getPriority().toString(), notification.getType().toString(), "UNREAD");

    }

    @Override
    public void markAsRead(Integer notificationId) {

        String query =
                "UPDATE notifications SET status = 'READ' WHERE id = ?";
    
        jdbcTemplate.update(query, notificationId);

    }

    @Override
    public void deleteNotification(Integer notificationId) {

        String query =
                "DELETE FROM notifications WHERE id = ?";

        jdbcTemplate.update(query, notificationId);

    }

    @Override
    public void deleteAllNotifications(Integer driverId) {

        String query =
                "DELETE FROM notifications WHERE driver_id = ?";

        jdbcTemplate.update(query, driverId);

    }

    @Override
    public List<Notification> getUnreadNotifications(Integer driverId) {

        String query =
                "SELECT * FROM notifications WHERE driver_id = ? AND status = 'UNREAD'";

        return jdbcTemplate.query(query,ROW_MAPPER , driverId);
    }

    @Override
    public List<Notification> getNotificationsByType(Integer driverId, NotificationType type) {

        String query = "SELECT * FROM notification WHERE driver_id = ? AND type = ?";


        return jdbcTemplate.query(query,ROW_MAPPER,driverId,type.toString());
    }

    @Override
    public List<Notification> getNotificationsByPriority(Integer driverId, NotificationPriority priority) {

        String query = "SELECT * FROM notification WHERE driver_id = ? AND priority = ?";


        return jdbcTemplate.query(query,ROW_MAPPER,driverId,priority.toString());
    }
}