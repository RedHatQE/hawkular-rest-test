package hawkular.rest.test;

import hawkular.rest.client.HawkularReasteasyClient;
import hawkular.rest.utils.HawkularRestTestUtil;

import javax.ws.rs.core.Response;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ResourceTest {
	
	@Test
	@Parameters({ "tenant", "resourceId" })
	public void createResource(String resourceId, String tenant) {

		String resourceJson = HawkularRestTestUtil.objectToJson(HawkularRestTestUtil.createUrlResource(resourceId));

		HawkularReasteasyClient hawkularClient = new HawkularReasteasyClient();
		System.out.println("hawkularClient " + hawkularClient);
		Response res2 = hawkularClient.post("/hawkular/inventory/" + tenant
				+ "/resources", resourceJson);
		Assert.assertTrue(res2.getStatus() == 200);

	}


}
