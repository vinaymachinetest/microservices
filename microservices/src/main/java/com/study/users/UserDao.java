package com.study.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> users= new ArrayList<User>();
	private static Integer userCount=3;
	
	static
	{
		users.add(new User(1,"vinay", new Date()));
		users.add(new User(2,"xyz", new Date()));
		users.add(new User(3,"abc", new Date()));
	}
	
	//returning all users list
	public List<User> getAll(){
		return users;
	}
	
	//get specific user
	public User getUser(Integer id)
	{
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	//add users
	public User addUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	//delete users
	public User deleteById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}				
		return null;		
	}

}
