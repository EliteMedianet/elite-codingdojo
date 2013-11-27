package net.elitem.codingdojo.web.rest;

import net.elitem.codingdojo.web.rest.pojo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Controller
@RequestMapping("/example")
public class ExampleController {

	@Autowired
	MongoOperations mongoTemplate;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getExample(@PathVariable String name, ModelMap model) {

		model.addAttribute("data", getExampleByName(name));

		return "example";
	}

	private Example getExampleByName(String name) {
		return mongoTemplate.findOne(query(where("name").is(name)), Example.class);
	}

	@RequestMapping(value = "/{name}.json", method = RequestMethod.GET)
	public
	@ResponseBody
	Example getExampleAsJson(@PathVariable String name) {
		return getExampleByName(name);
	}
}
