package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.Example;
import net.elitem.codingdojo.web.rest.pojo.PersonalityTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.ui.ModelMap;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
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
        given(mongoTemplate.findOne(query(where("name").is("name")), PersonalityTest.class)).willReturn(test);

        // when
        ModelMap modelMap = new ModelMap();
        PersonalityTest result=controller.getPersonalityTest("name");

        // then
        assertThat(result, is(test));
    }
}
