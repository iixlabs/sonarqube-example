/**
 * 
 */
package com.consoleconnect.mw.sonarqube.sample.test;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.consoleconnect.mw.sonarqube.sample.entity.Privilege;
import com.consoleconnect.mw.sonarqube.sample.entity.Role;
import com.consoleconnect.mw.sonarqube.sample.entity.User;
import com.consoleconnect.mw.sonarqube.sample.repo.UserRepository;

/**
 * @author dxiong
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

	@TestConfiguration
	static class TestContextConfiguration {

	}

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRespository;

	private User user = new User().withEmail("test@example.com").withPassword("password").withUsername("username")
			.withRoles(Arrays.asList(new Role().withName("ROLE_TEST")
					.withPrivileges(Arrays.asList(new Privilege().withName("PERMISSION_TEST")))));

	@Before
	public void setUp() {
		entityManager.persist(user);
	}

	@Test
	public void whenFindByEmailThenReturnUser() {
		User find = userRespository.findByEmail(user.getEmail());
		Assertions.assertThat(find).isNotNull();
		Assertions.assertThat(find.getEmail()).isEqualTo(user.getEmail());
		Assertions.assertThat(find.getRoles().size()).isSameAs(user.getRoles().size());

	}

	@Test
	public void whenFindByEmailThenReturnNull() {
		Assertions.assertThat(userRespository.findByEmail("test2@example.com")).isNull();
	}
}
