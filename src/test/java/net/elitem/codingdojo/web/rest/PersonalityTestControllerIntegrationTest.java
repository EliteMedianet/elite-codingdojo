package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.PersonalityTest;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context-config.xml")
public class PersonalityTestControllerIntegrationTest {

    @Autowired
    PersonalityTestController controller;

    @Test
    public void exampleDataIsLoadedFromMongoDB() {
        // when
        PersonalityTest personalityTest = controller.getPersonalityTest("A Test");

        // then
        assertNotNull(personalityTest);
        assertThat(personalityTest.getName(), is("A Test"));
        assertThat(personalityTest.getQuestions().size(), is(2));
        assertThat(personalityTest.getQuestions().get(0).getTitle(), is("Was für ein Tier bist du?"));
        assertThat(personalityTest.getQuestions().get(0).getQuestionId(), is("q1"));
        assertThat(personalityTest.getResults().size(), is(3));
    }
}
