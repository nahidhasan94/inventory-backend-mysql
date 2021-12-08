package com.inventory.service;

import com.inventory.dto.CategoryCreateDTO;
import com.inventory.dto.ResponseDTO;
import com.inventory.enums.Authority;
import com.inventory.model.Category;
import com.inventory.model.dummy.User;
import com.inventory.repository.CategoryRepository;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseDTO create(CategoryCreateDTO input, User requester) {
        Category category = new Category();

        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            category = categoryRepository.findByNameAndStatus(input.getName(), "V");
            if (category == null) {
                category = new Category();
                category.setName(input.getName());
                category.setStatus("V");
                categoryRepository.save(category);
            } else {
                return output.generateErrorResponse("Already exist");
            }

        }
        return output.generateSuccessResponse(category, "Success");
    }

    public ResponseDTO getList() {
        List<Category> categories = categoryRepository.findAllByStatus("V");
        if (categories == null) {
            return output.generateErrorResponse("No data found");
        } else {
            return output.generateSuccessResponse(categories, "Success!");
        }
    }

    public ResponseDTO get(long id) {
        Category category = categoryRepository.findByIdAndStatus(id, "V");
        if (category == null) {
            return output.generateErrorResponse("No data found");

        } else {
            return output.generateSuccessResponse(category, "Success");
        }

    }

    public ResponseDTO delete(long id,User requester) {
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            Category category = categoryRepository.findByIdAndStatus(id, "V");
            if (category == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                category.setStatus("D");
                categoryRepository.save(category);
                return output.generateSuccessResponse(category, "success");
            }

        } else {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }

}
