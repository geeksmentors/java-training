package com.example.Spring3;

import com.sun.research.ws.wadl.Representation;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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

    @GetMapping(path = "/hello/{name}")
    public String helloWorldPathVariable(@PathVariable String name) {
        String s1 = name;
        return "Hello "+ s1;
    }

    @RequestMapping("/user")
    public String getitem(@RequestParam("data") String itemid){

        return "Hi " + itemid;
    }
    // http://localhost:8080/user?data=6


    /*

    @PostMapping("/addAUser")
    @Consumes{MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    @Produces(MediaType.APPLICATION_JSON)
    User newEmployee(@RequestBody User user) {
        return user;
    }

     */
    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    public User addMember(@RequestBody User user) {
        System.out.println("Post call for Use Creation");
        return user;
    }

    @PutMapping(path="/user/{userId}",consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public User updateUser(@PathVariable String userId, @RequestBody User user)    {
        user.setId(userId);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteEmployee(@PathVariable(value = "id") Long employeeId)
            {
                System.out.println("Delete call for Use Creation"+ employeeId);
        return true;
    }


    /*
    @RequestMapping(value = "/user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody  String authenticate(@PathVariable("email") String anEmailAddress, MultiValueMap paramMap) throws Exception {
        if(paramMap == null && paramMap.get("password") == null) {
            throw new IllegalArgumentException("Password not provided");
        }
        return "Done, user Added";
    }

     */

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

