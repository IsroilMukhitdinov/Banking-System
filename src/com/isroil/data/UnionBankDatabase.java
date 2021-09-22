package com.isroil.data;

import java.util.ArrayList;

import com.isroil.entity.Database;
import com.isroil.entity.User;

public class UnionBankDatabase implements Database{

	private ArrayList<User> users;

	private static UnionBankDatabase db = null;

	private UnionBankDatabase() {
		User user1 = new User("Tom", 980, 5400);
		User user2 = new User("Abraham", 455, 1220);
		User user3 = new User("Tessa", 210, 10000);
		users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	public static UnionBankDatabase getDatabase() {
		if (db == null)
			db = new UnionBankDatabase();
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
