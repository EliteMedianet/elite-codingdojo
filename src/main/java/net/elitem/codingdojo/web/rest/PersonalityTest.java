package net.elitem.codingdojo.web.rest;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author kmarkwardt
 */
@Document(collection = "test")
public class PersonalityTest {
    String name;
    private List<Question> questions;

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public List <Question> getQuestions() {
        return this.questions;
    }


}
