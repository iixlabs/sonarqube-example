/**
 * 
 */

package com.consoleconnect.mw.sonarqube.sample.test;

import com.consoleconnect.mw.sonarqube.sample.entity.Role;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author dxiong
 *
 */

public class RoleTest {

  private static Role ROLE = new Role(1L);

  @Test
  public void testId() {
    Assert.assertTrue(ROLE.getId() == 1L);
  }

  @Test
  public void testName() {
    Assert.assertNull(ROLE.getName());
    ROLE.setName("Name");
    Assert.assertTrue(ROLE.getName().equals("Name"));
  }
}
