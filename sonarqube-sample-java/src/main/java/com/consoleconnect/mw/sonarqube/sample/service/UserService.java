/**
 * 
 */

package com.consoleconnect.mw.sonarqube.sample.service;

import com.consoleconnect.mw.sonarqube.sample.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author dxiong
 *
 */
public class UserService {

  private Map<String, User> email2User = new HashMap<>();

  /**
   * create a new user object
   * 
   * @param email
   *          email
   * @param password
   *          password
   * @return User
   */
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

  public User read(String email) {
    return email2User.get(email);
  }
}
