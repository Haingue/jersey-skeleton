package fr.iutinfo.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	//private WebTarget target;

	protected Application configure() {
		return new Api();
	}

	@Before
	public void init() {
		/*Client c = ClientBuilder.newClient();

		target = c.target("http://localhost:8080/v1");*/
	}

	@After
	public void stopJetty() {

	}

	@Test
	public void RegisterTest() {
		/*

		BDDFactory.initializeBdd();
		CorpDAO cDao = BDDFactory.getDbi().open(CorpDAO.class);
		cDao.insert("Auchan5", "auchan5.com");

		 * CorpDAO cDao = BDDFactory.getDbi().open(CorpDAO.class);
		 * cDao.insert("Auchan5", "auchan5.com");
		 * 
		 * UserDto u = new UserDto(); u.setLogin("toto@auchan.com");
		 * u.setPass("azerty"); u.setNom("Tartanpion"); u.setPrenom("Toto");
		 * 
		 * Entity<UserDto> userEntity = Entity.entity(u, MediaType.APPLICATION_JSON);
		 * 
		 * Response response = target.path("/user/register").request().post(userEntity);
		 * 
		 * assertEquals(201, response.getStatus());
		 * 
		 * assertTrue(response.getEntity() != null);
		 */
	}
	
	@Test
	public void getUserTest() {
		/*try {
			String response = get("http://localhost:8080/v1/user");
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/*public static String get(String url) throws IOException {
		String source = "";
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			source += inputLine;
		in.close();
		return source;
	}*/

	/*public static String post(String adress, List<String> keys, List<String> values) throws IOException {
		String result = "";
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		try {
			// encodage des paramètres de la requête
			String data = "";
			for (int i = 0; i < keys.size(); i++) {
				if (i != 0)
					data += "&amp;";
				data += URLEncoder.encode(keys.get(i), "UTF-8") + "=" + URLEncoder.encode(values.get(i), "UTF-8");
			}
			// création de la connection
			URL url = new URL(adress);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);

			// envoi de la requête
			writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(data);
			writer.flush();


			// lecture de la réponse
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				result += ligne;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
			try {
				reader.close();
			} catch (Exception e) {
			}
		}
		return result;
	}*/

}
