package ie.sanshou.aerobics.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ie.sanshou.aerobics.model.Greeting;
import lombok.extern.slf4j.XSlf4j;

@Controller
@XSlf4j
@RequestMapping("/hi")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	log.info("Hi log");
    	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
}
