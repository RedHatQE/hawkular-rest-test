package hawkular.rest.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class HawkularReasteasyClient {
	String baseurl;
	String path;

	public HawkularReasteasyClient() {

		this.baseurl = (System.getProperty("baseUrl") != null) ? System
				.getProperty("baseUrl") : "http://localhost:8080";
	}

//	public HawkularReasteasyClient(String baseurl) {
//		this.baseurl = baseurl;
//	}

	public Response get(String path) {
		Client client = ResteasyClientBuilder.newClient();
		Response res = client.target(baseurl + path)
				.request(MediaType.APPLICATION_JSON).get();
		return res;
	}

	public Response post(String path, String data) {
		Client client = ResteasyClientBuilder.newClient();
		Response res = client.target(baseurl + path)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(data, MediaType.APPLICATION_JSON));

		return res;
	}

	public Response put(String path, String data) {
		Client client = ResteasyClientBuilder.newClient();
		Response res = client.target(baseurl + path)
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(data, MediaType.APPLICATION_JSON));

		return res;
	}

	public Response delete(String path) {
		Client client = ResteasyClientBuilder.newClient();
		Response res = client.target(baseurl + path)
				.request(MediaType.APPLICATION_JSON).delete();

		return res;
	}

}
