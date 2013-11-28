package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.Example;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.contains;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class PersonalityTestControllerUnitTest {

	PersonalityTestController controller;

	@Mock
	private MongoOperations mongoTemplate;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.controller=new PersonalityTestController();
		controller.mongoTemplate=this.mongoTemplate;
	}

	@Test
	public void personalityTestDataIsLoaded() {
		// given
        PersonalityTest test = new PersonalityTest();
        test.name = "testName";
        given(mongoTemplate.findOne(query(where("name").is("testName")), PersonalityTest.class)).willReturn(test);

		// when
        PersonalityTest personalityTest=controller.getPersonalityTest("testName");

		// then
		assertThat(personalityTest.getName(), is("testName"));
	}
}
