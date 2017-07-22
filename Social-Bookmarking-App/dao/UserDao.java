package com.shirish.thrillio.dao;

import com.shirish.thrillio.DataStore;
import com.shirish.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
