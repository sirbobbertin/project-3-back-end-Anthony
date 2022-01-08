package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.entity.CartItem;
import com.project3.revtech.entity.Discount;
import com.project3.revtech.entity.Product;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    void testAddProductService() throws ApplicationException {
        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(new Discount());
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(null);
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(1);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount.setProduct(product);
        discount.setProductId(123);

        Product product1 = new Product();
        product1.setCartItems(new ArrayList<>());
        product1.setDiscount(discount);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(1);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount1.setProduct(product1);
        discount1.setProductId(123);

        Product product2 = new Product();
        ArrayList<CartItem> cartItemList = new ArrayList<>();
        product2.setCartItems(cartItemList);
        product2.setDiscount(discount1);
        product2.setImageUrl("https://example.org/example");
        product2.setImages(new ArrayList<>());
        product2.setProductCategory("Product Category");
        product2.setProductCost(BigDecimal.valueOf(42L));
        product2.setProductDescription("Product Description");
        product2.setProductId(123);
        product2.setProductName("Product Name");
        product2.setProductQty(1);
        product2.setProductRemoved(true);
        product2.setProductSku("Product Sku");
        when(this.productRepository.saveAndFlush((Product) any())).thenReturn(product2);
        ProductPojo productPojo = new ProductPojo(123, "Product Sku", "Product Name", BigDecimal.valueOf(42L),
                "Product Category", "Product Description", 1, "https://example.org/example", true);

        ProductPojo actualAddProductServiceResult = this.productServiceImpl.addProductService(productPojo);
        assertSame(productPojo, actualAddProductServiceResult);
        assertEquals(123, actualAddProductServiceResult.getProductId());
        assertEquals("42", actualAddProductServiceResult.getProductCost().toString());
        verify(this.productRepository).saveAndFlush((Product) any());
        assertEquals(cartItemList, this.productServiceImpl.getAllDiscountProductService());
    }

    @Test
    void testUpdateProductService() throws ApplicationException {
        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(new Discount());
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(null);
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(1);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount.setProduct(product);
        discount.setProductId(123);

        Product product1 = new Product();
        product1.setCartItems(new ArrayList<>());
        product1.setDiscount(discount);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(1);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount1.setProduct(product1);
        discount1.setProductId(123);

        Product product2 = new Product();
        ArrayList<CartItem> cartItemList = new ArrayList<>();
        product2.setCartItems(cartItemList);
        product2.setDiscount(discount1);
        product2.setImageUrl("https://example.org/example");
        product2.setImages(new ArrayList<>());
        product2.setProductCategory("Product Category");
        product2.setProductCost(BigDecimal.valueOf(42L));
        product2.setProductDescription("Product Description");
        product2.setProductId(123);
        product2.setProductName("Product Name");
        product2.setProductQty(1);
        product2.setProductRemoved(true);
        product2.setProductSku("Product Sku");
        when(this.productRepository.save((Product) any())).thenReturn(product2);
        ProductPojo productPojo = new ProductPojo(123, "Product Sku", "Product Name", BigDecimal.valueOf(42L),
                "Product Category", "Product Description", 1, "https://example.org/example", true);

        ProductPojo actualUpdateProductServiceResult = this.productServiceImpl.updateProductService(productPojo);
        assertSame(productPojo, actualUpdateProductServiceResult);
        assertEquals("42", actualUpdateProductServiceResult.getProductCost().toString());
        verify(this.productRepository).save((Product) any());
        assertEquals(cartItemList, this.productServiceImpl.getAllDiscountProductService());
    }

    @Test
    void testDeleteProductService() throws ApplicationException {
        doNothing().when(this.productRepository).deleteById((Integer) any());
        assertTrue(this.productServiceImpl.deleteProductService(123));
        verify(this.productRepository).deleteById((Integer) any());
        List<ProductPojo> expectedAllProductService = this.productServiceImpl.getAllDiscountProductService();
        assertEquals(expectedAllProductService, this.productServiceImpl.getAllProductService());
    }

    @Test
    void testGetAProductService() throws ApplicationException {
        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(null);
        discount.setProduct(new Product());
        discount.setProductId(123);

        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(discount);
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(BigDecimal.valueOf(42L));
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(1);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        discount1.setDiscountPercentage(valueOfResult);
        discount1.setProduct(product);
        discount1.setProductId(123);

        Product product1 = new Product();
        ArrayList<CartItem> cartItemList = new ArrayList<>();
        product1.setCartItems(cartItemList);
        product1.setDiscount(discount1);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(1);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");
        Optional<Product> ofResult = Optional.of(product1);
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);
        ProductPojo actualAProductService = this.productServiceImpl.getAProductService(123);
        assertEquals("https://example.org/example", actualAProductService.getImageUrl());
        assertTrue(actualAProductService.isProductRemoved());
        assertEquals("Product Sku", actualAProductService.getProductSku());
        assertEquals(1, actualAProductService.getProductQty());
        assertEquals("Product Name", actualAProductService.getProductName());
        assertEquals(123, actualAProductService.getProductId());
        assertEquals("Product Description", actualAProductService.getProductDescription());
        BigDecimal productCost = actualAProductService.getProductCost();
        assertEquals(valueOfResult, productCost);
        assertEquals("Product Category", actualAProductService.getProductCategory());
        assertEquals("42", productCost.toString());
        verify(this.productRepository).findById((Integer) any());
        assertEquals(cartItemList, this.productServiceImpl.getAllDiscountProductService());
    }

    @Test
    void testGetAProductService2() throws ApplicationException {
        when(this.productRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertNull(this.productServiceImpl.getAProductService(123));
        verify(this.productRepository).findById((Integer) any());
        List<ProductPojo> expectedAllProductService = this.productServiceImpl.getAllDiscountProductService();
        assertEquals(expectedAllProductService, this.productServiceImpl.getAllProductService());
    }

    @Test
    void testGetAllProductService() throws ApplicationException {
        when(this.productRepository.findAll()).thenReturn(new ArrayList<>());
        List<ProductPojo> actualAllProductService = this.productServiceImpl.getAllProductService();
        assertTrue(actualAllProductService.isEmpty());
        verify(this.productRepository).findAll();
        assertEquals(actualAllProductService, this.productServiceImpl.getAllDiscountProductService());
    }

    @Test
    void testGetAllProductService2() throws ApplicationException {
        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(null);
        discount.setProduct(new Product());
        discount.setProductId(123);

        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(discount);
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(BigDecimal.valueOf(42L));
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(0);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount1.setProduct(product);
        discount1.setProductId(123);

        Product product1 = new Product();
        product1.setCartItems(new ArrayList<>());
        product1.setDiscount(discount1);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(0);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(1, this.productServiceImpl.getAllProductService().size());
        verify(this.productRepository).findAll();
        assertEquals(1, this.productServiceImpl.getAllDiscountProductService().size());
    }

    @Test
    void testGetAllProductService3() throws ApplicationException {
        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(null);
        discount.setProduct(new Product());
        discount.setProductId(123);

        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(discount);
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(BigDecimal.valueOf(42L));
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(0);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount1.setProduct(product);
        discount1.setProductId(123);

        Product product1 = new Product();
        product1.setCartItems(new ArrayList<>());
        product1.setDiscount(discount1);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(0);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");

        Discount discount2 = new Discount();
        discount2.setDiscountDescription("3");
        discount2.setDiscountId(3);
        discount2.setDiscountPercentage(null);
        discount2.setProduct(new Product());
        discount2.setProductId(123);

        Product product2 = new Product();
        product2.setCartItems(new ArrayList<>());
        product2.setDiscount(discount2);
        product2.setImageUrl("https://example.org/example");
        product2.setImages(new ArrayList<>());
        product2.setProductCategory("Product Category");
        product2.setProductCost(BigDecimal.valueOf(42L));
        product2.setProductDescription("Product Description");
        product2.setProductId(123);
        product2.setProductName("Product Name");
        product2.setProductQty(0);
        product2.setProductRemoved(true);
        product2.setProductSku("Product Sku");

        Discount discount3 = new Discount();
        discount3.setDiscountDescription("3");
        discount3.setDiscountId(3);
        discount3.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount3.setProduct(product2);
        discount3.setProductId(123);

        Product product3 = new Product();
        product3.setCartItems(new ArrayList<>());
        product3.setDiscount(discount3);
        product3.setImageUrl("https://example.org/example");
        product3.setImages(new ArrayList<>());
        product3.setProductCategory("Product Category");
        product3.setProductCost(BigDecimal.valueOf(42L));
        product3.setProductDescription("Product Description");
        product3.setProductId(123);
        product3.setProductName("Product Name");
        product3.setProductQty(0);
        product3.setProductRemoved(true);
        product3.setProductSku("Product Sku");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product3);
        productList.add(product1);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(2, this.productServiceImpl.getAllProductService().size());
        verify(this.productRepository).findAll();
        assertEquals(2, this.productServiceImpl.getAllDiscountProductService().size());
    }

    @Test
    void testGetADiscountProductService() throws ApplicationException {
        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(null);
        discount.setProduct(new Product());
        discount.setProductId(123);

        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(discount);
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(BigDecimal.valueOf(42L));
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(1);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        discount1.setDiscountPercentage(valueOfResult);
        discount1.setProduct(product);
        discount1.setProductId(123);

        Product product1 = new Product();
        ArrayList<CartItem> cartItemList = new ArrayList<>();
        product1.setCartItems(cartItemList);
        product1.setDiscount(discount1);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(1);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");
        Optional<Product> ofResult = Optional.of(product1);
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);
        ProductPojo actualADiscountProductService = this.productServiceImpl.getADiscountProductService(123);
        assertEquals("https://example.org/example", actualADiscountProductService.getImageUrl());
        assertTrue(actualADiscountProductService.isProductRemoved());
        assertEquals("Product Sku", actualADiscountProductService.getProductSku());
        assertEquals(1, actualADiscountProductService.getProductQty());
        assertEquals("Product Name", actualADiscountProductService.getProductName());
        assertEquals(123, actualADiscountProductService.getProductId());
        assertEquals("Product Description", actualADiscountProductService.getProductDescription());
        BigDecimal productCost = actualADiscountProductService.getProductCost();
        assertEquals(valueOfResult, productCost);
        assertEquals("Product Category", actualADiscountProductService.getProductCategory());
        assertEquals("42", productCost.toString());
        verify(this.productRepository).findById((Integer) any());
        assertEquals(cartItemList, this.productServiceImpl.getAllDiscountProductService());
    }

    @Test
    void testGetADiscountProductService2() throws ApplicationException {
        when(this.productRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertNull(this.productServiceImpl.getADiscountProductService(123));
        verify(this.productRepository).findById((Integer) any());
        List<ProductPojo> expectedAllProductService = this.productServiceImpl.getAllDiscountProductService();
        assertEquals(expectedAllProductService, this.productServiceImpl.getAllProductService());
    }

    @Test
    void testGetAllDiscountProductService() throws ApplicationException {
        when(this.productRepository.findAll()).thenReturn(new ArrayList<>());
        List<ProductPojo> actualAllDiscountProductService = this.productServiceImpl.getAllDiscountProductService();
        assertTrue(actualAllDiscountProductService.isEmpty());
        verify(this.productRepository).findAll();
        assertEquals(actualAllDiscountProductService, this.productServiceImpl.getAllProductService());
    }

    @Test
    void testGetAllDiscountProductService2() throws ApplicationException {
        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(null);
        discount.setProduct(new Product());
        discount.setProductId(123);

        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(discount);
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(BigDecimal.valueOf(42L));
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(0);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount1.setProduct(product);
        discount1.setProductId(123);

        Product product1 = new Product();
        product1.setCartItems(new ArrayList<>());
        product1.setDiscount(discount1);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(0);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(1, this.productServiceImpl.getAllDiscountProductService().size());
        verify(this.productRepository).findAll();
        assertEquals(1, this.productServiceImpl.getAllProductService().size());
    }

    @Test
    void testGetAllDiscountProductService3() throws ApplicationException {
        Discount discount = new Discount();
        discount.setDiscountDescription("3");
        discount.setDiscountId(3);
        discount.setDiscountPercentage(null);
        discount.setProduct(new Product());
        discount.setProductId(123);

        Product product = new Product();
        product.setCartItems(new ArrayList<>());
        product.setDiscount(discount);
        product.setImageUrl("https://example.org/example");
        product.setImages(new ArrayList<>());
        product.setProductCategory("Product Category");
        product.setProductCost(BigDecimal.valueOf(42L));
        product.setProductDescription("Product Description");
        product.setProductId(123);
        product.setProductName("Product Name");
        product.setProductQty(0);
        product.setProductRemoved(true);
        product.setProductSku("Product Sku");

        Discount discount1 = new Discount();
        discount1.setDiscountDescription("3");
        discount1.setDiscountId(3);
        discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount1.setProduct(product);
        discount1.setProductId(123);

        Product product1 = new Product();
        product1.setCartItems(new ArrayList<>());
        product1.setDiscount(discount1);
        product1.setImageUrl("https://example.org/example");
        product1.setImages(new ArrayList<>());
        product1.setProductCategory("Product Category");
        product1.setProductCost(BigDecimal.valueOf(42L));
        product1.setProductDescription("Product Description");
        product1.setProductId(123);
        product1.setProductName("Product Name");
        product1.setProductQty(0);
        product1.setProductRemoved(true);
        product1.setProductSku("Product Sku");

        Discount discount2 = new Discount();
        discount2.setDiscountDescription("3");
        discount2.setDiscountId(3);
        discount2.setDiscountPercentage(null);
        discount2.setProduct(new Product());
        discount2.setProductId(123);

        Product product2 = new Product();
        product2.setCartItems(new ArrayList<>());
        product2.setDiscount(discount2);
        product2.setImageUrl("https://example.org/example");
        product2.setImages(new ArrayList<>());
        product2.setProductCategory("Product Category");
        product2.setProductCost(BigDecimal.valueOf(42L));
        product2.setProductDescription("Product Description");
        product2.setProductId(123);
        product2.setProductName("Product Name");
        product2.setProductQty(0);
        product2.setProductRemoved(true);
        product2.setProductSku("Product Sku");

        Discount discount3 = new Discount();
        discount3.setDiscountDescription("3");
        discount3.setDiscountId(3);
        discount3.setDiscountPercentage(BigDecimal.valueOf(42L));
        discount3.setProduct(product2);
        discount3.setProductId(123);

        Product product3 = new Product();
        product3.setCartItems(new ArrayList<>());
        product3.setDiscount(discount3);
        product3.setImageUrl("https://example.org/example");
        product3.setImages(new ArrayList<>());
        product3.setProductCategory("Product Category");
        product3.setProductCost(BigDecimal.valueOf(42L));
        product3.setProductDescription("Product Description");
        product3.setProductId(123);
        product3.setProductName("Product Name");
        product3.setProductQty(0);
        product3.setProductRemoved(true);
        product3.setProductSku("Product Sku");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product3);
        productList.add(product1);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(2, this.productServiceImpl.getAllDiscountProductService().size());
        verify(this.productRepository).findAll();
        assertEquals(2, this.productServiceImpl.getAllProductService().size());
    }
}

