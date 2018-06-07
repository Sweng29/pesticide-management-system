/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.models.ProductModel;
import com.pms.models.RecieptModel;

import java.util.List;

/**
 *
 * @author farhan baloch
 */
public interface ProductDAO {

    public ProductModel getProductWithId(Integer prodcutId);
    public List<ProductModel> getAllProduct();
    public Integer deleteProduct(ProductModel productModel);
    public Integer updateProduct(ProductModel productModel);
    public Integer addProduct(ProductModel productModel);
   public void updateProductsStock(List<RecieptModel> list);
    public int getProductId(String productName);
    public int updateProductQuantity(ProductModel productModel);
}
