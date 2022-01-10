package com.project3.revtech.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import  com.project3.revtech.dao.ImageControllerRepository;
import  com.project3.revtech.entity.Image;
import com.project3.revtech.entity.Product;
import  com.project3.revtech.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

@SpringBootTest
public class StorageServiceTest {

    // Test for Image Upload method without Mockito --//

    @Autowired
    private StorageService storageService;

    @MockBean
    private ImageControllerRepository imageControllerRepository;

    @Test
    public void uploadImageTest() throws ApplicationException {
        Image uploadImage = new Image(
                1,
                "https://media.istockphoto.com/photos/newly-released-iphone-13-pro-mockup-set-with-back-and-front-angles-picture-id1356372494?k=20&m=1356372494&s=612x612&w=0&h=4IyK75PK9dd4zY-CPAF_scPK-HwsoYS2mmWJZzBwp2A=",
                new Product(11,
                        "JLDRH11R00234", "VPOW Sound",
                        new BigDecimal(210.71), "Bose 2",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                        6, "http://pexels.com/JldroidImg1", false),
                1);
        //We must access Spring Data JPA Built-in methods directly in  repository
        when(imageControllerRepository.saveAndFlush(any(Image.class))).thenReturn(uploadImage);
    }
}
