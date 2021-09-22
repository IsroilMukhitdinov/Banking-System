package com.isroil.entity;

public interface Database {
	public User findUser(final String name,final int id);
	public boolean addUser(final User user);
	public boolean removeUser(final User user);
}
