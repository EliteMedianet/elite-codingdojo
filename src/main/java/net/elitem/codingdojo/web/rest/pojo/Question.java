package net.elitem.codingdojo.web.rest.pojo;

import java.util.List;

/**
 * @author kmarkwardt
 */
public class Question {

    String questionId;
    String title;
    List<Choice> choices;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
