package net.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.twitter.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long>{

}
