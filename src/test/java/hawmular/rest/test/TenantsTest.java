package hawmular.rest.test;

import javax.ws.rs.core.Response;

import hawkular.rest.client.HawkularReasteasyClient;
import hawkular.rest.utils.HawkularRestTestUtil;

import org.testng.Assert;
import org.testng.annotations.*;


public class TenantsTest {

	String path;

	@Test
	@Parameters({ "tenant" })
	public void listTenantsTest(String tenant) {

		HawkularReasteasyClient hawkularClient = new HawkularReasteasyClient();
		System.out.println("hawkularClient " + hawkularClient);
		Response res = hawkularClient.get("/hawkular/inventory/" + tenant
				+ "/resources");
		System.out.println(" get tenants status  " + res);

	}

	@Test
	@Parameters({ "tenant" })
	public void createTenantTest(String tenant) {

		String tenantjson = HawkularRestTestUtil.objectToJson(HawkularRestTestUtil.createTenant(tenant));
		
//		String tenantStr = "{" + "\"id\": \"com.acme.eng\","
//				+ "\"retentions\": {" + " \"numeric\": 100,"
//				+ "\"availability\": 80" + "}" + "}";
		HawkularReasteasyClient hawkularClient = new HawkularReasteasyClient();
		System.out.println("hawkularClient " + hawkularClient);
		Response res2 = hawkularClient.post("/hawkular-metrics/tenants",
				tenantjson);
		System.out.println("status  = "+res2.getStatus());

	}

	
}
