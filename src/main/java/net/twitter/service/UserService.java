package net.twitter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.twitter.entity.User;
import net.twitter.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	 public List<User> getAllUser(){
		 return userRepo.findAll();
	 }
	 
	 public Optional<User> findById(long id){
		 return userRepo.findById(id);
	 }
	 
	 public void deleteUser(long id) {
		 userRepo.deleteById(id);
	 }
}
