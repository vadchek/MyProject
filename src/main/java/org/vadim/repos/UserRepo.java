package org.vadim.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vadim.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
