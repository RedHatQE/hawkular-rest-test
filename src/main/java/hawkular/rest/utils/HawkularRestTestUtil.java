package hawkular.rest.utils;

import java.util.HashMap;
import java.util.Map;

import org.hawkular.inventory.api.Resource;
import org.hawkular.inventory.api.ResourceType;
import org.hawkular.metrics.core.api.MetricType;
import org.hawkular.metrics.core.api.Tenant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HawkularRestTestUtil {

	public static String objectToJson(Object obj) {

		GsonBuilder builder = new GsonBuilder();
		Gson jsonObject = builder.create();
		return jsonObject.toJson(obj);

	}

	public static Tenant createTenant(String tenantId) {

		Tenant t = new Tenant();
		t.setId(tenantId);
		t.setRetention(MetricType.NUMERIC, 100);

		return t;

	}

	public static Resource createUrlResource(String resourceId) {
		
		Map<String, String> parameter = new HashMap();
		parameter.put("url", "http://hawkular.org");
		
		Resource resource = new Resource();
		resource.setParameters(parameter);
		resource.setId(resourceId);
		resource.setType(ResourceType.URL);
		
		return resource;

	}

}
