package com.inventory.service;

import com.inventory.dto.*;
import com.inventory.enums.Authority;
import com.inventory.model.Product;
import com.inventory.model.TransactionLog;
import com.inventory.model.dummy.User;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.TransactionRepository;
import com.inventory.utills.Utils;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionLogService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseDTO create(TransactionLogCreateDTO input, User requester) {
        TransactionLog transactionLog = new TransactionLog();
        List<Product> products = new ArrayList<>();
        if (input != null && input.getCheckOutDTOS().size() > 0) {
            for (int i=0 ; i < input.getCheckOutDTOS().size(); i++){
                Product product = new Product();
                //TODO: use findByIdAndStatus Instead of findByNameAndStatus
                product = productRepository.findByNameAndStatus(input.getCheckOutDTOS().get(i).getItemName(), "V");
                if (product.getQuantity() > input.getCheckOutDTOS().get(i).getQuantity()){
                    product.setQuantity(product.getQuantity() - input.getCheckOutDTOS().get(i).getQuantity());
                    productRepository.save(product);
                } else {
                    return output.generateErrorResponse(product.getName() + " Stock Out.");
                }
                products.add(product);
            }
        } else {
            return output.generateErrorResponse("Empty Cart");
        }


        String items = "";
        for (int i=0 ; i < products.size(); i++){
            items = products.get(i).getName() + "," + items;
        }

        for (int i=0 ; i < input.getCheckOutDTOS().size(); i++){
            input.setTotal(input.getTotal() + (input.getCheckOutDTOS().get(i).getPrice() * input.getCheckOutDTOS().get(i).getQuantity()));
        }

        String billNo = Utils.generateRandomNumber(6);
        transactionLog = new TransactionLog();
        transactionLog.setBillNo(billNo);
        transactionLog.setItems(items);
        transactionLog.setCustomerName(input.getCustomerName());
        transactionLog.setMobileNumber(input.getMobileNumber());
        transactionLog.setTotal(input.getTotal());
//        transactionLog.setDetailsInfo(input.getCheckOutDTOS());
        transactionLog.setDate(new Date());
        transactionLog.setStatus("V");
        transactionRepository.save(transactionLog);
        return output.generateSuccessResponse(transactionLog, "Success");
    }

    public ResponseDTO getList() {
        List<TransactionLog> transactionLogs = transactionRepository.findAllByStatus("V");
        if (transactionLogs == null) {
            return output.generateErrorResponse("No data found");
        } else {
            return output.generateSuccessResponse(transactionLogs, "Success!");
        }
    }


    public ResponseDTO get(long id) {
        TransactionLog transactionLog = transactionRepository.findByIdAndStatus(id, "V");
        if (transactionLog == null) {
            return output.generateErrorResponse("No data found");

        } else {
            return output.generateSuccessResponse(transactionLog, "Success");
        }

    }

    public ResponseDTO update(TransactionLogUpdateDTO input, long id, User requester) {
        TransactionLog transactionLog;

        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            transactionLog = transactionRepository.findByIdAndStatus(id, "V");
            if (transactionLog == null) {
                transactionLog = new TransactionLog();
                transactionLog.setBillNo(input.getBillNo());
                transactionLog.setMobileNumber(input.getMobileNumber());
                transactionLog.setTotal(input.getTotal());
                transactionLog.setDate(input.getDate());
                transactionLog.setStatus("V");
                transactionRepository.save(transactionLog);
                return output.generateSuccessResponse(transactionLog, "Successfully updated");
            } else {
                return output.generateErrorResponse("NO data found");
            }

        } else {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }

    public ResponseDTO delete(long id,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            TransactionLog transactionLog = transactionRepository.findByIdAndStatus(id, "V");
            if (transactionLog == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                transactionLog.setStatus("D");
                transactionRepository.save(transactionLog);
                return output.generateSuccessResponse(transactionLog, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }

    }


}
