package net.twitter.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.twitter.entity.Post;
import net.twitter.entity.User;
import net.twitter.repository.PostRepo;
import net.twitter.repository.UserRepo;

@Service
public class PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private UserRepo userRepo;
	
	public List<Post> getAllPosts(){
		return postRepo.findAll();
	}
	
	public Post getPostById(Long id) {
		return postRepo.findById(id).orElse(null);
	}

	
	public Post createPost(Long userId , Post post) {
		User user = userRepo.findById(userId).orElse(null);
		if(user != null) {
			post.setUser(user);
			
			post.setCreatedAt(LocalDateTime.now());
			return postRepo.save(post);
		}
		return null;
	}
	
	public Post updatePost(Long id , Post postDetail) {
        Post post = postRepo.findById(id).orElse(null);
        if(post != null) {
            post.setContent(postDetail.getContent());
            return postRepo.save(post);
        }
        return null;
    }
	
	
	
	public void deletePost(Long id) {
		postRepo.deleteById(id);
	}
	
	
}
