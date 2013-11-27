package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.Example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class ExampleControllerUnitTest {

	ExampleController controller;

	@Mock
	private MongoOperations mongoTemplate;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.controller=new ExampleController();
		controller.mongoTemplate=this.mongoTemplate;
	}

	@Test
	public void exampleDataIsLoaded() {
		// given
		Example example = new Example();
		given(mongoTemplate.findOne(query(where("name").is("name")), Example.class)).willReturn(example);

		// when
		ModelMap modelMap = new ModelMap();
		String path=controller.getExample("name", modelMap);

		// then
		assertThat(path, is("example"));
		assertThat((Example) modelMap.get("data"), is(example));
	}
}
