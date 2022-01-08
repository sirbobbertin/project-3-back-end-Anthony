package com.project3.revtech.imageuploadtesting;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import  com.project3.revtech.dao.ImageControllerRepository;
import  com.project3.revtech.entity.Image;
import com.project3.revtech.entity.Product;
import  com.project3.revtech.exception.ApplicationException;
import  com.project3.revtech.service.StorageService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

@SpringBootTest
public class StorageServiceTest {

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
        when(imageControllerRepository.saveAndFlush(any(Image.class))).thenReturn(uploadImage);
    }
}
