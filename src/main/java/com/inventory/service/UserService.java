package com.inventory.service;

import com.inventory.dto.*;
import com.inventory.enums.Authority;
import com.inventory.model.Product;
import com.inventory.model.User;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.UserRepository;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private UserRepository userRepository;

    public ResponseDTO create(UserCreateDTO input, com.inventory.model.dummy.User requester) {
        User user = new User();

        user = userRepository.findByUsernameAndStatus(input.getUsername(), "V");
        if (user == null) {
            User adminUser = new User();

            adminUser = userRepository.findByAuthorityAndStatus(Authority.ROLE_ADMIN, "V");

            if (adminUser != null){
                if(adminUser.getPassword().equals(input.getAdminPassword())){
                    user = new User();
                    user.setName(input.getName());
                    user.setUsername(input.getUsername());
                    user.setAddress(input.getAddress());
                    user.setAdminPassword(input.getAdminPassword());
                    user.setPassword(input.getPassword());
                    user.setMobileNumber(input.getMobileNumber());
                    user.setAuthority(Authority.ROLE_EMPLOYEE);
                    user.setStatus("V");
                    userRepository.save(user);
                } else {
                    return output.generateErrorResponse("Wrong Admin Password");
                }
            } else {
                return output.generateErrorResponse("Admin User Not Found");
            }

        } else {
            return output.generateErrorResponse("Already exist");
        }

        return output.generateSuccessResponse(user, "Success");
    }

    public ResponseDTO getList() {
        List<User> users = userRepository.findAllByStatus("V");
        if (users == null) {
            return output.generateErrorResponse("No data found");
        } else {
            return output.generateSuccessResponse(users, "Success!");
        }
    }

    public ResponseDTO get(long id) {
        User user = userRepository.findByIdAndStatus(id, "V");
        if (user == null) {
            return output.generateErrorResponse("No data found");

        } else {
            return output.generateSuccessResponse(user, "Success");
        }

    }

    public ResponseDTO delete(long id, com.inventory.model.dummy.User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            User user = userRepository.findByIdAndStatus(id, "V");
            if (user == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                user.setStatus("D");
                userRepository.save(user);
                return output.generateSuccessResponse(user, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }

    }

    public ResponseDTO changePassword(ChangePasswordDTO input, com.inventory.model.dummy.User requester) {
        User user = userRepository.findByUsernameAndStatus(input.getUsername(), "V");
        if (user == null) {
            return output.generateErrorResponse("User Not Found!");
        } else {
            if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
                user.setAdminPassword(input.getAdminPassword());
                userRepository.save(user);
            } else if (requester.hasAuthority(Authority.ROLE_EMPLOYEE)) {
                user.setPassword(input.getPassword());
                userRepository.save(user);
            }
        }

        return output.generateSuccessResponse(user, "Success");
    }

    public ResponseDTO login(LogInDTO input, com.inventory.model.dummy.User requester) {
        User user = userRepository.findByUsernameAndStatus(input.getUsername(), "V");
        if (user == null) {
            return output.generateErrorResponse("User Not Found!");
        } else {
            if (user.getPassword().equals(input.getPassword())){
                return output.generateSuccessResponse(user, "Success");
            } else {
                return output.generateErrorResponse("Wrong Password!");
            }
        }

    }

}
