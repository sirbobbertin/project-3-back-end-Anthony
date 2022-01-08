package com.project3.revtech.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.project3.revtech.dao.ImageControllerRepository;
import com.project3.revtech.service.StorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ContextConfiguration(classes = {StorageController.class})
@ExtendWith(SpringExtension.class)
class StorageControllerTest {
    @Autowired
    private StorageController storageController;

    @MockBean
    private StorageService storageService;

    @Test
    void testDownloadFile() throws Exception {
        when(this.storageService.downloadFile((String) any())).thenReturn("AAAAAAAA".getBytes("UTF-8"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/file/download/{fileName}", "foo.txt");
        MockMvcBuilders.standaloneSetup(this.storageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/octet-stream"))
                .andExpect(MockMvcResultMatchers.content().string("AAAAAAAA"));
    }

    @Test
    void testDeleteFile() throws Exception {
        when(this.storageService.deleteFile((String) any())).thenReturn("Delete File");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/file/delete/{fileName}", "foo.txt");
        MockMvcBuilders.standaloneSetup(this.storageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete File"));
    }

    private ImageControllerRepository imageControllerRepository;

}

