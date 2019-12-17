package com.example.Spring3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.*;

        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/getAString")
    public String getAString() {
        return "Java Backend";
    }

    /*@RequestMapping("/getAUser")
    public User getAUser() {
        User user1 = new User();
        user1.setId("1");
        user1.setName("Name");
        return user1;
    }*/
}
/*
@RestController
public class Controller {


        @GetMapping("/users")
        public List<User> getAllUsers() {
            User user1 = new User();
            user1.setName("Raju");
            user1.setId("123");
            List<User> users = new ArrayList<User>();
            users.add(user1);
            return users;
        }
}

 */

 @GetMapping(path = "/hello/{name}")
    public String helloWorldPathVariable(@PathVariable String name) {
        String s1 = name;
        return "Hello "+ s1;
    }

=========================
        
            @RequestMapping("/user")
    public String getitem(@RequestParam("data") String itemid){

        return "Hi " + itemid;
    }
    // http://localhost:8080/user?data=6
        

