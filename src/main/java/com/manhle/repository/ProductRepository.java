package com.manhle.repository;

import com.manhle.entities.ProductEntity;
import com.manhle.enums.Color;
import com.manhle.enums.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
//param 2 of CrudRepository = data type id of ProductRepository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByNameContainingAndCreateDateBetween(String str, Date createdate1, Date createDate2);

    List<ProductEntity> findByCategory_NameContainingAndProductDetail_PriceGreaterThanEqual(String str, int price);

    List<ProductEntity> findByProductDetail_Color_ColorEAndProductDetail_QuantityGreaterThan(Color color, int quanlity);

    List<ProductEntity> findByProductDetail_Color_ColorEAndProductDetail_Size_SizeEOrderByCreateDateDesc(Color color, Size size);

    //
//    List<ProductEntity> findByCreateDateBetween(Date timeStart, Date timeEnd);
//
    @Query("select p from ProductEntity p where p.name like ?1 and p.createDate between ?2 and ?3")
    List<ProductEntity> findNameAndCreateDateJPQL(String str, Date createdate1, Date createDate2);

    @Query("select p from ProductEntity p where p.category.name like ?1 and p.productDetail.price >= ?2")
    List<ProductEntity> findCategoryNameAndPriceJPQL(String str, int price);

    @Query("select p from ProductEntity p where p.productDetail.color.colorE = ?1 and p.productDetail.quantity > ?2")
    List<ProductEntity> findColorAndQuantityJPQL(Color color, int quanlity);

    @Query("select p from ProductEntity p where p.productDetail.color.colorE = ?1 and p.productDetail.size.sizeE = ?2")
    List<ProductEntity> findCorlorAndSizeOrderByCreateDateJPQL(Color color, Size size);

//    @Query("select p from ProductEntity p where p.createDate  between ?1 and ?2")
//    List<ProductEntity> findCreateDateBetweenJPQL(Date timeStart, Date timeEnd);
//
    @Query(value = "select * from product where `name` like :nameStr and create_date between :create1 and :create2",
            nativeQuery = true)
    List<ProductEntity> findNameAndCreateDateNative(@Param("nameStr") String str, @Param("create1") Date createdate1, @Param("create2") Date createDate2);

    @Query(value = "select * from product p\n" +
            "join category c on c.id = p.category_id\n" +
            "join productdetail pd on pd.product_id = p.id\n" +
            "where c.name like :str and pd.price >=:priceDouble", nativeQuery = true)
    List<ProductEntity> findCategoryNameAndPriceNative(@Param("str") String str, @Param("priceDouble") int price);

    @Query(value = "select * from product p\n" +
            "join productdetail pd on pd.product_id = p.id\n" +
            "join color cl on cl.id = pd.color_id\n" +
            "where cl.colorE = :color and pd.quantity> :price", nativeQuery = true)
    List<ProductEntity> findColorAndQuantityNative(@Param("color") Color color, @Param("price") int price);

    @Query(value = "select * from product p\n" +
            "join productdetail pd on pd.product_id = p.id\n" +
            "join color cl on cl.id = pd.color_id\n" +
            "join size s on s.id = pd.size_id\n" +
            "where cl.colorE = ?1 and s.sizeE = ?2\n" +
            "order by p.create_date desc;", nativeQuery = true)
    List<ProductEntity> findColorAndSizeOrderByCreateDateNative(Color color, Size size);
//
//    @Query(value = "select * from product where create_date BETWEEN ?1 and ?2", nativeQuery = true)
//    List<ProductEntity> findCreateDateBetweenNative(Date timeStart, Date timeEnd);
}

