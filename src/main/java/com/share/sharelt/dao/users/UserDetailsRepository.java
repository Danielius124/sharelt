package com.share.sharelt.dao.users;

import com.share.sharelt.entity.users.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
