/**
 * 
 */

package com.consoleconnect.mw.sonarqube.sample.test;

import com.consoleconnect.mw.sonarqube.sample.entity.User;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * @author dxiong
 *
 */

public class UserTest {

  private static final String ID = UUID.randomUUID().toString();
  private static User USER = new User(ID);

  @Test
  public void testId() {
    Assert.assertTrue(USER.getId().equals(ID));
  }

  @Test
  public void testEmail() {
    Assert.assertNull(USER.getEmail());
    USER.setEmail("test@email.com");
    Assert.assertTrue(USER.getEmail().equals("test@email.com"));
  }
}
