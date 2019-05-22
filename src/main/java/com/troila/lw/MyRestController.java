package com.troila.lw;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPerson(@PathVariable Integer id) {
		Person p = new Person();
		p.setId(id);
		p.setName("Dar");
		p.setMessage("");
		
		return p;
	}
	
	@RequestMapping(value = "/person/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createPerson(@RequestBody Person person) {
		System.out.println(person.getName() + "==" + person.getId());
		return "success ! id = " + person.getId();
	}
	
	@RequestMapping(value = "/person/createXML", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public String createXMLPerson(@RequestBody Person person) {
		System.out.println(person.getName() + "**" + person.getId());
		return "<result><message>success</message></result>";
	}
}
