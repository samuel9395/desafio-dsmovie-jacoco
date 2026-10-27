package com.devsuperior.dsmovie.tests;

import com.devsuperior.dsmovie.entities.User;

public class UserFactory {
	
	public static User createUserEntity() {
		User user = new User(2L, "Maria", "maria@gmail.com", "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
		return user;
	}
}
