package com.manhle.service;

import com.manhle.entities.ProductEntity;
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

    /*public List<ProductEntity> search(String str){
//        return  productRepository.findByNameContainingOrderByCreateDateDesc(str);
//        return  productRepository.findNameLikeOrderByCreateDateDescJPQL(str);
        return  productRepository.findNameLikeOrderByCreateDateDescNative(str);
    }

    public List<ProductEntity> searchByPriceGreaterThanEqual(double price){
//        return productRepository.findByPriceGreaterThanEqual(price);
//        return  productRepository.findPriceGreaterThanEqualJPQL(price);
        return  productRepository.findPriceGreaterThanEqualNative(price);
    }

    public List<ProductEntity> searchByPriceLessThanEqual(double price){
//        return productRepository.findByPriceLessThanEqual(price);
//        return productRepository.findPriceLessThanEqualJPQL(price);
        return productRepository.findPriceLessThanEqualNative(price);
    }

    public List<ProductEntity> searchByCreateDate(Date date){
//        return productRepository.findByCreateDateAfter(date);
//        return productRepository.findCreateDateAfterJPQL(date);
        return productRepository.findCreateDateAfterNative(date);
    }

    public List<ProductEntity> searchByCreateDateBetween(Date timeStart, Date timeEnd){
//        return productRepository.findByCreateDateBetween(timeStart, timeEnd);
//        return productRepository.findCreateDateBetweenJPQL(timeStart, timeEnd);
        return productRepository.findCreateDateBetweenNative(timeStart, timeEnd);
    }
*/

}
