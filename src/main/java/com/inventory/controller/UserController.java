package com.inventory.controller;

import com.inventory.constant.HttpHeader;
import com.inventory.dto.*;
import com.inventory.model.dummy.User;
import com.inventory.service.TransactionLogService;
import com.inventory.service.UserService;
import com.inventory.utills.Utils;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseDTO login(@RequestBody LogInDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr) {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = userService.login(input, requester);
        return result;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseDTO register(@RequestBody UserCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr) {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = userService.create(input, requester);
        return result;
    }

    @RequestMapping(value = "/users/users-list", method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr) {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = userService.getList();
        return result;
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") long id, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = userService.get(id);
        return result;
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") long id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = userService.delete(id,requester);
        return result;
    }

    @RequestMapping(value = "/user/change-password", method = RequestMethod.PUT)
    public ResponseDTO changePassword(@RequestBody ChangePasswordDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr) {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = userService.changePassword(input, requester);
        return result;
    }

}
