package com.project3.revtech.productstesting;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import  com.project3.revtech.dao.ProductRepository;
import  com.project3.revtech.entity.Product;
import  com.project3.revtech.exception.ApplicationException;
import  com.project3.revtech.service.ProductService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

   // Test for Adding A Product
    @Test
    public void addProductTest() throws ApplicationException {
        Product newProductTest = new Product( 11,
                "JLDRH11R00234", "VPOW Sound",
                new BigDecimal(210.71), "Bose 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                6, "http://pexels.com/JldroidImg1", false);
        when(productRepository.saveAndFlush(any(Product.class))).thenReturn(newProductTest);
    }

    //Test for updating an existing product
    @Test
    public void updateProductTest() throws ApplicationException {
        Product updateProduct = new Product( 11,
                "JLDRH11R00234", "VM-POW Sound 2",
                new BigDecimal(888.78), "Bose 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                6, "http://pexels.com/JldroidImg25", false);
        when(productRepository.save(updateProduct)).thenReturn(updateProduct);

    }
    // Test for getting One Product
    @Test
    public void getOneProductTest() throws ApplicationException {
        Product getOneProduct = new Product(11,
                "JLDRH11R00234", "VM-POW Sound 2",
                new BigDecimal(888.78), "Bose 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                6, "http://pexels.com/JldroidImg25", false);
        when(productRepository.findById(2)).thenReturn(Optional.of(getOneProduct));
    }

    // Test for getting all Products
    @Test
    public void getAllProductTest() throws ApplicationException {
        when(productRepository.findAll()).thenReturn(Stream.of(
                new Product()).collect(Collectors.toList()));
        assertEquals(1, productService.getAllProductService().size());
    }

    // Test for deleting an existing  Product
    @Test
    public void deleteProductTest() throws ApplicationException {
        Product deleteProduct = new Product( 11,
                "JLDRH11R00234", "VM-POW Sound 2",
                new BigDecimal(888.78), "Bose 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                6, "http://pexels.com/JldroidImg25", false);
        productService.deleteProductService(11);
        verify(productRepository, times(1)).deleteById(11);

    }
}
