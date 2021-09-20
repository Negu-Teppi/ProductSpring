package com.manhle.service;

import com.manhle.entities.ProductEntity;
import com.manhle.enums.Color;
import com.manhle.enums.Size;
import com.manhle.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public ProductEntity getProduct(int id) {
        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    public void save(ProductEntity product) {
        productRepository.save(product);
    }

    public boolean deleteProduct(int id) {
        productRepository.deleteById(id);
        return productRepository.existsById(id);
    }

    public List<ProductEntity> searchByNameAndCreateDate(String str, Date createdate1, Date createDate2){
//        return productRepository.findByNameContainingAndCreateDateBetween(str, createdate1, createDate2);
//        return productRepository.findNameAndCreateDateJPQL(str, createdate1, createDate2);
        return productRepository.findNameAndCreateDateNative(str, createdate1, createDate2);
    }

    public List<ProductEntity> searchCategoryNameAndPrice(String str, int price){
//        return productRepository.findByCategory_NameContainingAndProductDetail_PriceGreaterThanEqual(str, price);
//        return productRepository.findCategoryNameAndPriceJPQL(str, price);
        return productRepository.findCategoryNameAndPriceNative(str, price);
    }

    public List<ProductEntity> searchByColorAndQuanlity(Color color, int quanlity){
//        return productRepository.findByProductDetail_Color_ColorEAndProductDetail_QuantityGreaterThan(color, quanlity);
//        return productRepository.findColorAndQuantityJPQL(color, quanlity);
        return productRepository.findColorAndQuantityNative(color, quanlity);
    }

    public List<ProductEntity> searchByColorAndSize(Color color, Size size){
//        return productRepository.findByProductDetail_Color_ColorEAndProductDetail_Size_SizeEOrderByCreateDateDesc(color, size);
//        return productRepository.findCorlorAndSizeOrderByCreateDateJPQL(color, size);
        return productRepository.findColorAndSizeOrderByCreateDateNative(color, size);
    }

//    public List<ProductEntity> searchByCreateDateBetween(Date timeStart, Date timeEnd){
////        return productRepository.findByCreateDateBetween(timeStart, timeEnd);
////        return productRepository.findCreateDateBetweenJPQL(timeStart, timeEnd);
////        return productRepository.findCreateDateBetweenNative(timeStart, timeEnd);
//    }

}
