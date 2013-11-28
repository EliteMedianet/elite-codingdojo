package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author kmarkwardt
 */
@Controller
@RequestMapping("/personalityTest")
public class PersonalityTestController {

    @Autowired
    MongoOperations mongoTemplate;

    @RequestMapping(value = "/{name}.json", method = RequestMethod.GET)
    @ResponseBody
    public PersonalityTest getPersonalityTest(@PathVariable String name) {
        return mongoTemplate.findOne(query(where("name").is(name)), PersonalityTest.class);
    }
}
