package com.company.chatterbook.controllers;

import com.company.chatterbook.models.ChatterPost;
import com.company.chatterbook.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ChatterbookController {
    // list of Users to mack a database
    private List<User> userList;

    public ChatterbookController() {
        // integrating dummy data

        // creating users
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        // creating posts for users
        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        // populating list if users
        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    // route to get all users
    // HTTP method: GET
    // URI: /users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getUsers() {
        return userList;
    }

    // route to get user by username (case-sensitive)
    // HTTP method: GET
    // URI: /users/{username}
    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    // must use same case as the "name" state of respective user
    public User getUserByUsername(@PathVariable String username) {
        for (User user : userList) {
            if (user.getName().equals(username))
                return  user;
        }
        return null;
    }

    // route to get list of chatterPosts for a user by username
    // HTTP method: GET
    // URI: /users/{username}/posts
    @RequestMapping(value = "/users/{username}/posts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    // must use same case as the "name" state of respective user
    public List<ChatterPost> getListOfChatterPostsByUsername(@PathVariable String username) {
        for (User user : userList) {
            if (user.getName().equals(username))
                return  user.getChatterPosts();
        }
        return null;
    }
}
