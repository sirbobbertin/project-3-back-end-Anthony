package com.project3.revtech.controller;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedPojo.ProductAndDiscountPojo;
import com.project3.revtech.pojo.CartPojo;
import com.project3.revtech.service.ProductDiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("http://ec2-50-16-74-43.compute-1.amazonaws.com:7777/api/product-and-discount")
public class ProductAndDiscountController {

    @Autowired
    ProductDiscountServiceImpl productDiscountService;

    @GetMapping("{bid}")
    ResponseEntity<ProductAndDiscountPojo> getItem(@PathVariable("bid") int productId) throws ApplicationException {
        return ResponseEntity.ok()
                .header("Content-type", "application/json")
                .body(productDiscountService.getOneProductWithDiscount(productId));
    }
}
