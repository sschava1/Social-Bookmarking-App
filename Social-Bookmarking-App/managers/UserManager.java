package com.shirish.thrillio.managers;

import com.shirish.thrillio.dao.UserDao;
import com.shirish.thrillio.entities.User;

public class UserManager {

	private static UserManager instance = new UserManager();
	private static UserDao userDao = new UserDao();
	
	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();

		user.setId(id);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);

		return user;
	}
	
	public User[] getUsers() {
		return userDao.getUsers();
	}
}
