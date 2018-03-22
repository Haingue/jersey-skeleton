package fr.iutinfo.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private WebTarget target;

	protected Application configure() {
		return new Api();
	}

	@Before
	public void init() {
		Client c = ClientBuilder.newClient();

		target = c.target("http://localhost:8080/v1");
	}

	@After
	public void stopJetty() {

	}

	/*
	 * @Test public void should_return_current_user_with_authorization_header() {
	 * h.createUserWithPassword("tclavier", "motdepasse", "graindesel"); String
	 * authorization = "Basic " + Base64.encodeAsString("tclavier:motdepasse"); User
	 * utilisateur = target(url).request().header(AUTHORIZATION,
	 * authorization).get(User.class); assertEquals("tclavier",
	 * utilisateur.getName()); }
	 * 
	 */

	@Test
	public void RegisterTest() {
		CorpDAO cDao = BDDFactory.getDbi().open(CorpDAO.class);
		cDao.insert("Auchan5", "auchan5.com");

		UserDto u = new UserDto();
		u.setLogin("toto@auchan.com");
		u.setPass("azerty");
		u.setNom("Tartanpion");
		u.setPrenom("Toto");

		Entity<UserDto> userEntity = Entity.entity(u, MediaType.APPLICATION_JSON);

		Response response = target.path("/user/register").request().post(userEntity);

		assertEquals(201, response.getStatus());

		assertTrue(response.getEntity() != null);
	}

}
