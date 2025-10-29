package com.github.muhsenerbe.aigateway.domain.user;

import com.github.muhsenerbe.aigateway.domain.shared.BaseJpaEntity;
import com.github.muhsenerbe.aigateway.domain.shared.IllegalObjectException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
public class User extends BaseJpaEntity {

    public static final int USERNAME_MAX_LENGTH = 50;
    public static final int USERNAME_MIN_LENGTH = 6;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    private User(UUID id, String username, String password, boolean isActive) {
        super(id);
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    @Builder(access = AccessLevel.PROTECTED)
    private static User create(String username, String password) {
        User user = new User(null, username, password, true);
        user.validate();
        return user;
    }

    private void validate() {
        List<String> errors = new ArrayList<>();

        if (username == null || username.isBlank() || username.length() < USERNAME_MIN_LENGTH || username.length() > USERNAME_MAX_LENGTH) {
            errors.add("Username is required, and it must be between %d and %d characters long".formatted(USERNAME_MIN_LENGTH, USERNAME_MAX_LENGTH));
        }

        if (password == null || password.isBlank())
            errors.add("An encrypted password is required.");

        if (!errors.isEmpty())
            throw new IllegalObjectException(String.join(" * ", errors));
    }


}
