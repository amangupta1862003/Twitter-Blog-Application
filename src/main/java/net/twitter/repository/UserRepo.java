package net.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.twitter.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
