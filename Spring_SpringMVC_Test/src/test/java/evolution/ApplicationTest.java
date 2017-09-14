package evolution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)// entry-point to start using the Spring Test framework. SpringRunner is an alias for the SpringJUnit4ClassRunner.
@ContextConfiguration(classes = {Application.class})// Load the context configuration and bootstrap the context that the test will use.
@WebAppConfiguration// Load the web application context.
public class ApplicationTest {
	@Autowired
	private WebApplicationContext webApplicationContext;// Loads all the application beans and controllers into the context.
	
	private MockMvc mockMvc;
	
	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testEnvironment() {
		Assert.notNull(webApplicationContext.getServletContext());
	}
	
	@Test
	public void testGet() throws Exception {
		mockMvc.perform(get("/get"))
		.andExpect(status().isOk());
	}
}
