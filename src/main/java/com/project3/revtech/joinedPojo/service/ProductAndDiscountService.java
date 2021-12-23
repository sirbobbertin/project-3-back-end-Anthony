package com.project3.revtech.joinedPojo.service;

import java.util.List;

public interface ProductAndDiscountService {
    List<ProductAndDiscountService> getAllProducts();
    List<ProductAndDiscountService> getAllDiscountedProducts();
    List<ProductAndDiscountService> getSearchedProducts();
    List<ProductAndDiscountService> getProductsByCategory();
}
