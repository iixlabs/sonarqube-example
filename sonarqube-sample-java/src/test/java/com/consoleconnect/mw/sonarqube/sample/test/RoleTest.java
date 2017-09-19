/**
 * 
 */
package com.consoleconnect.mw.sonarqube.sample.test;

import org.junit.Assert;
import org.junit.Test;

import com.consoleconnect.mw.sonarqube.sample.entity.Role;

/**
 * @author dxiong
 *
 */

public class RoleTest {

	private static Role ROLE = new Role(1L);

	@Test
	public void testId() {
		Assert.assertTrue(ROLE.getId() == 1l);
	}

	@Test
	public void testName() {
		Assert.assertNull(ROLE.getName());
		ROLE.setName("Name");
		Assert.assertTrue(ROLE.getName().equals("Name"));
	}
}
