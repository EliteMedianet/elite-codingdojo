package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context-config.xml")
public class PersonalityTestControllerIntegrationTest {

	@Autowired
	PersonalityTestController controller;

	@Test
	public void personalityTestDataIsLoadedFromMongoDB() {
		// when
		PersonalityTest personalityTest = controller.getPersonalityTest("A Test");

		// then
		assertNotNull(personalityTest);
		assertNotNull(personalityTest.getQuestions());
        assertEquals(2, personalityTest.getQuestions().size());
        assertEquals(2, personalityTest.getQuestions().size());

        assertTestDataIsCorrect(personalityTest);
    }

    private void assertTestDataIsCorrect(PersonalityTest personalityTest) {
        assertEquals("q1", personalityTest.getQuestions().get(0).questionId);
        assertEquals("Was für ein Tier bist du?", personalityTest.getQuestions().get(0).title);
    }
}
