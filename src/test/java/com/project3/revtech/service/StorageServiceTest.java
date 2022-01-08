package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.StringInputStream;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StorageService.class, String.class})
@ExtendWith(SpringExtension.class)
class StorageServiceTest {
    @MockBean
    private AmazonS3 amazonS3;

    @Autowired
    private StorageService storageService;

    @Test
    void testDownloadFile() throws SdkClientException, UnsupportedEncodingException {
        S3Object s3Object = new S3Object();
        s3Object.setObjectContent(new StringInputStream("Lorem ipsum dolor sit amet."));
        when(this.amazonS3.getObject((String) any(), (String) any())).thenReturn(s3Object);
        assertEquals(27, this.storageService.downloadFile("foo.txt").length);
        verify(this.amazonS3).getObject((String) any(), (String) any());
    }

    @Test
    void testDeleteFile() throws SdkClientException {
        doNothing().when(this.amazonS3).deleteObject((String) any(), (String) any());
        assertEquals("foo.txt removed ...", this.storageService.deleteFile("foo.txt"));
        verify(this.amazonS3).deleteObject((String) any(), (String) any());
    }
}

