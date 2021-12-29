package com.project3.revtech.service;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartPojo;

public interface CartService {
    CartPojo addCart(CartPojo cart) throws ApplicationException;
    CartPojo updateCart(CartPojo cart) throws ApplicationException;
    boolean removeCart(CartPojo cart) throws ApplicationException;

}
