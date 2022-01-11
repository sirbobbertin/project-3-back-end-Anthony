package com.project3.revtech.service;

import com.project3.revtech.dao.CartItemRepository;
import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.entity.CartItem;
import com.project3.revtech.entity.Discount;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartItemPojo;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import static com.project3.revtech.prototype.CartAndItemsPojoPrototype.cartItemPojoTestObj;
import static com.project3.revtech.prototype.CartAndItemsPojoPrototype.cartItemTestObj;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {   CartItemServiceImpl.class,
                                    CartServiceImpl.class})
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
class CartItemServiceImplTest {

    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private CartItemRepository cartItemRepository;

    @Autowired
    CartItemServiceImpl cartItemService;

    @Before
    public void beforeClass() {
    }

    @Test
    void addItem() throws ApplicationException {
        CartItem testEntity = cartItemTestObj();
        when(cartItemRepository.saveAndFlush((CartItem) any())).thenReturn(testEntity);
        CartItemPojo item = cartItemService.addItem(cartItemPojoTestObj());
        assertNotNull(item);
        assertEquals(cartItemPojoTestObj(), item);

    }

    @Test
    void updateItem() throws ApplicationException {
        CartItem testEntity = cartItemTestObj();
        when(cartItemRepository.saveAndFlush((CartItem) any())).thenReturn(testEntity);
        CartItemPojo item = cartItemService.updateItem(cartItemPojoTestObj());
        assertNotNull(item);
        assertEquals(cartItemPojoTestObj(), item);

    }

    @Test
    void removeItem() throws ApplicationException {
        CartItem testEntity = cartItemTestObj();
        when(cartItemRepository.saveAndFlush((CartItem) any())).thenReturn(testEntity);
        boolean item = cartItemService.removeItem(testEntity.getCartItemId());
        assertNotNull(item);
        assertEquals(true, item);
    }

}