package com.Erik.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private AdressHandler handler = new AdressHandler();

    @CrossOrigin
    @GetMapping("/greet")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting((counter.incrementAndGet()), String.format(template, name));
    }

    @CrossOrigin
    @GetMapping("/createAdress")
    public void createAdress(@RequestParam(value = "name", defaultValue = "Jason") String name,@RequestParam(value = "area", defaultValue = "Porfyrvägen 1") String area){
        handler.createAdress(counter.incrementAndGet(),name,area);
    }

    @CrossOrigin
    @GetMapping("/getList")
    public List<AdressInfo> getList()
    {
        return handler.getListAdress();
    }

    @CrossOrigin
    @GetMapping("/sortListName")
    public void sortedList(@RequestParam(value = "name", defaultValue = "Jason") String name)
    {
        handler.sortListByName(name);
    }
}
