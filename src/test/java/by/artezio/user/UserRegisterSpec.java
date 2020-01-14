package by.artezio.user;

import by.artezio.TestSampleData;
import by.artezio.configuration.JpaConfiguration;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;

import javax.transaction.Transactional;
import java.io.IOException;

@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {JpaConfiguration.class})
public class UserRegisterSpec implements TestSampleData {
	@Autowired
	private ApplicationUserService userService;

	@Test
	public void testStatus() throws IOException {

		// Given
		HttpUriRequest request = new HttpPost("http://localhost:8080/api_v1/registration");
		request.setHeader("Content-type", "application/json");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		// Then
        assertEquals(200,response.getStatusLine().getStatusCode());

		
	}


}
