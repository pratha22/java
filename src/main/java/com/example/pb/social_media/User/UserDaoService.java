package com.example.pb.social_media.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pb.social_media.User.repository.UserPostsRepository;
import com.example.pb.social_media.User.repository.UserRepository;

@Component
public class UserDaoService {
	
	private UserRepository userRepo;
	public UserPostsRepository postsRepo;

	
	@Autowired
	public UserDaoService( UserRepository userRepo, UserPostsRepository postsRepo) {
		this.userRepo = userRepo;
		this.postsRepo = postsRepo;
		
	}
	

	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User getUser(int userId) {
	    Long userIdLong = (long) userId;  // Cast int to Long
	    return userRepo.findById(userIdLong).get();
	}
	
	public User save(User user) {
		userRepo.save(user);
		return user;
	}
	
   public void deleteUserById(int id ) {
	   userRepo.deleteById((long)id);
	}
   
	
   public void deleteUser(User user ) {
	   userRepo.delete(user);
	}
   
   public UserPosts saveUserPosts(UserPosts posts) {
	   return postsRepo.save(posts);
   }
	
	/*public static int id = 0;
	
	static List <User> userList = new ArrayList<User>(List.of(
			new User(++id, "A_user",  LocalDate.of(2020,6,9)),
			new User(++id, "B_user",  LocalDate.of(2010,8,29)),
			new User(++id, "C_user",  LocalDate.of(2015,10,19))
			));
	
	
	public List<User> findAll(){
		return userList;
	}
	
	public User save(User user) {
		user.setId(++id);
		userList.add(user);
		
		return user;
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		
		return userList.stream().filter(user -> user.getId() == userId).findFirst().orElse(null);
	}

	public void deleteUser(User user) {
		userList.remove(user);
	}
	
	public void deleteUserById(int id ) {
		
		userList.removeIf(user -> user.getId() == id);
	}
  */

}
