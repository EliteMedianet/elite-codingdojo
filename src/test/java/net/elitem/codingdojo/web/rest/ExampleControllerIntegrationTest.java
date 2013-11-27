package net.elitem.codingdojo.web.rest;

import junit.framework.Assert;
import net.elitem.codingdojo.web.rest.pojo.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context-config.xml")
public class ExampleControllerIntegrationTest {

	@Autowired
	ExampleController controller;

	@Test
	public void exampleDataIsLoadedFromMongoDB() {
		// when
		Example example = controller.getExampleAsJson("HelloWorld");

		// then
		assertNotNull(example);
		assertThat(example.getName(), is("HelloWorld"));
		assertThat(example.getNumber(), is(42));
		assertThat(example.getEntries().size(), is(3));
	}
}
