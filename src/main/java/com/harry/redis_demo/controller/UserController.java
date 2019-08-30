package com.harry.redis_demo.controller;

import com.harry.redis_demo.model.User;
import com.harry.redis_demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "get user list")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

    @ApiOperation(value = "create user", notes = "create user by user object")
    @ApiImplicitParam(name = "user", value = "user object", required = true, dataType = "User")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

    @ApiOperation(value = "update user info", notes = "update user info by user object")
    @ApiImplicitParam(name = "user", value = "user object", required = true, dataType = "User")
    @RequestMapping(value="/", method=RequestMethod.PUT)
    public User putUser(@RequestBody User user) {
        return userService.update(user);
    }

    @ApiOperation(value = "delete user", notes = "delete user by id")
    @ApiImplicitParams(
        @ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "Long", paramType = "path")
    )
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "success";
    }

    @ApiOperation(value = "get user", notes = "get user info by id")
    @ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
