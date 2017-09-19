/**
 * 
 */
package com.consoleconnect.mw.sonarqube.sample.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.consoleconnect.mw.sonarqube.sample.entity.User;

/**
 * @author dxiong
 *
 */
public class UserService {

	private Map<String, User> email2User = new HashMap<String, User>();

	public User create(String email, String password) {
		if (email2User.containsKey(email)) {
			throw new IllegalArgumentException(String.format("%s already exist", email));
		}

		User user = new User(UUID.randomUUID().toString());
		user.setEmail(email);
		user.setPassword(password);

		email2User.put(email, user);
		return user;
	}
}
