package com.share.sharelt.dao.users;

import com.share.sharelt.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
