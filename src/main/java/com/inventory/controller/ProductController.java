package com.inventory.controller;

import com.inventory.constant.HttpHeader;
import com.inventory.dto.*;
import com.inventory.model.dummy.User;
import com.inventory.service.ProductService;
import com.inventory.utills.Utils;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody ProductCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr) {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.create(input, requester);
        return result;
    }

    @RequestMapping(value = "/product/product-list", method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr) {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.getList();
        return result;
    }

    @RequestMapping(value = "/product/category-list", method = RequestMethod.GET)
    public ResponseDTO getListByCategory(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr,@RequestParam("category") String categoryName){
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.getListByCategory(categoryName);
        return result;
    }

    @RequestMapping(value = "/product/all-categories", method = RequestMethod.GET)
    public ResponseDTO getAllProductCategories(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr){
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.getAllProductCategories();
        return result;
    }

    @RequestMapping(value = "/search/search-list", method = RequestMethod.GET)
    public ResponseDTO getListBySearch(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr,@RequestParam("search") String searchName){
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.getListBySearch(searchName);
        return result;
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") long id, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.get(id);
        return result;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseDTO update(@PathVariable("id") long prodId , @RequestBody ProductUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.update(input, prodId, requester);

        return result;
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") long id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = productService.delete(id,requester);
        return result;
    }

}

