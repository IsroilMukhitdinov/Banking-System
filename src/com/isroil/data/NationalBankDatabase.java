package com.isroil.data;

import java.util.ArrayList;

import com.isroil.entity.Database;
import com.isroil.entity.User;

public class NationalBankDatabase implements Database{

	private ArrayList<User> users;

	private static NationalBankDatabase db = null;

	private NationalBankDatabase() {
		User user1 = new User("Noah", 123, 4200);
		User user2 = new User("Ignatius", 127, 3800);
		User user3 = new User("Peter", 135, 5700);
		users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	public static NationalBankDatabase getDatabase() {
		if (db == null)
			db = new NationalBankDatabase();
		return db;

	}
	
	public User findUser(final String name,final int id) {
		for (User user : users) {
			if (name.equals(user.getName()) && id == user.getId())
				return user;
		}
		return null;
	}
	
	public boolean addUser(final User user) {
		return users.add(user);
	}
	public boolean removeUser(final User user) {
		return users.remove(user);
	}

}
