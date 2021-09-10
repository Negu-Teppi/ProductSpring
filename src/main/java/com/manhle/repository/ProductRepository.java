package com.manhle.repository;

import com.manhle.entities.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
//param 2 of CrudRepository = data type id of ProductRepository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
//    List<ProductEntity> findByNameContainingOrderByCreateDateDesc(String str);
//
//    List<ProductEntity> findByPriceGreaterThanEqual(double price);
//
//    List<ProductEntity> findByPriceLessThanEqual(double price);
//
//    List<ProductEntity> findByCreateDateAfter(Date date);
//
//    List<ProductEntity> findByCreateDateBetween(Date timeStart, Date timeEnd);
//
//    @Query("select p from ProductEntity p where p.name like ?1 ORDER BY p.createDate desc ")
//    List<ProductEntity> findNameLikeOrderByCreateDateDescJPQL(String str);
//
//    @Query("select p from ProductEntity p where p.price >= ?1")
//    List<ProductEntity> findPriceGreaterThanEqualJPQL(double price);
//
//    @Query("select p from ProductEntity p where p.price <= ?1")
//    List<ProductEntity> findPriceLessThanEqualJPQL(double price);
//
//    @Query("select p from ProductEntity p where p.createDate >= ?1")
//    List<ProductEntity> findCreateDateAfterJPQL(Date date);
//
//    @Query("select p from ProductEntity p where p.createDate  between ?1 and ?2")
//    List<ProductEntity> findCreateDateBetweenJPQL(Date timeStart, Date timeEnd);
//
//    @Query(value = "select * from product where `name` like :nameStr order by create_date desc",
//        nativeQuery = true)
//    List<ProductEntity> findNameLikeOrderByCreateDateDescNative(@Param("nameStr") String str);
//
//    @Query(value = "select * from product where price >= :priceDouble", nativeQuery = true)
//    List<ProductEntity> findPriceGreaterThanEqualNative(@Param("priceDouble") double price);
//
//    @Query(value = "select * from product where price <= :priceDouble", nativeQuery = true)
//    List<ProductEntity> findPriceLessThanEqualNative(@Param("priceDouble") double price);
//
//    @Query(value = "select * from product where create_date >= ?1", nativeQuery = true)
//    List<ProductEntity> findCreateDateAfterNative(Date date);
//
//    @Query(value = "select * from product where create_date BETWEEN ?1 and ?2", nativeQuery = true)
//    List<ProductEntity> findCreateDateBetweenNative(Date timeStart, Date timeEnd);
}

