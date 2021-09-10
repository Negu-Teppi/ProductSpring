package com.manhle.main;

import com.manhle.configuration.SpringConfig;
import com.manhle.entities.*;
import com.manhle.enums.Color;
import com.manhle.enums.Size;
import com.manhle.service.CategoryService;
import com.manhle.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductService productService = (ProductService) context.getBean("productService");
        CategoryService categoryService = (CategoryService) context.getBean("categoryService");

//        displayProducts(productService);
//        displayProduct(productService,2);
//        createProduct(2, productService, categoryService);
//        updateProduct(4,productService, categoryService,9);
        deleteProduct(productService, 9);

//        using query methos
//        search(productService, "r");
//        search(productService, "%r%");
//        searchByPriceGreater(productService, 10000);
//        searchByPriceLess(productService, 10000);
//        searchByCreateDate(productService,new SimpleDateFormat("yyyy/MM/dd").parse("2021/08/31"));
//        searchByCreateDateBetween(productService, new SimpleDateFormat("yyyy/MM/dd").parse(("2021/08/01")),
//          new SimpleDateFormat("yyyy/MM/dd").parse(("2021/08/31")));

    }

    private static void displayProducts(ProductService productService) {
        List<ProductEntity> products = productService.getProducts();
        if (products != null && products.size() > 0) {
            for (ProductEntity product : products) {
                System.out.println(product.toString());
            }
        }
    }

    private static void displayProduct(ProductService productService, int id) {
        ProductEntity product = productService.getProduct(id);
        if (product != null) {
            System.out.println(product.toString());
        } else {
            System.out.println("Cannot get product with id = " + id);
        }
    }

    private static void createProduct(int categoryId, ProductService productService, CategoryService categoryService) {
        CategoryEntity category = categoryService.findCategoryById(categoryId);
        if (category != null) {
            ProductEntity product = new ProductEntity();
            product.setCreateDate(new Date());
            product.setDescription("New Account");
            product.setName("Snapdragon 895");
            product.setCategory(category);


            ProductDetailEntity productDetail = new ProductDetailEntity();
            productDetail.setPrice(1000000);
            productDetail.setQuantity(122);

            ColorEntity color = new ColorEntity();
            color.setColorE(Color.BLACK);
            productDetail.setColor(color);

            SizeEntity size = new SizeEntity();
            size.setSizeE(Size.S);
            productDetail.setSize(size);
            productDetail.setProduct(product);

            product.setProductDetail(productDetail);

            ImageEntity image = new ImageEntity();
            image.setName("create image");
            image.setName("create image2");
            image.setProduct(product);

            List<ImageEntity> images = new ArrayList<>();
            images.add(image);


            product.setImages(images);
            productService.save(product);
            if (product.getId() > 0) {
                displayProduct(productService, product.getId());
            } else {
                System.out.println("Save error");
            }
        } else {
            System.out.println("Not found category with id: " + categoryId);
        }


    }

    private static void updateProduct(int categoryId, ProductService productService, CategoryService categoryService, int productId) {
        CategoryEntity category = categoryService.findCategoryById(categoryId);
        if (category != null) {
            ProductEntity product = productService.getProduct(productId);
            if (product != null) {
                product.setCategory(category);
                product.setDescription("Update product");

                ColorEntity color = new ColorEntity();
                color.setColorE(Color.BLUE);

                SizeEntity size = new SizeEntity();
                size.setSizeE(Size.XL);


                product.getProductDetail().setQuantity(200);
                product.getProductDetail().setColor(color);
                product.getProductDetail().setSize(size);
                product.getProductDetail().setProduct(product);
                productService.save(product);

                displayProduct(productService, productId);
            } else {
                System.out.println("Cannot get product with id = " + productId);
            }
        } else {
            System.out.println("Not found category with id = " + categoryId);
        }
    }

    private static void deleteProduct(ProductService productService, int id) {
        if (!productService.deleteProduct(id)) {
            System.out.println("Delete ok");
        } else {
            System.out.println("Error");
        }
    }

//    private static void search(ProductService productService, String str) {
//        List<ProductEntity> products = productService.search(str);
//        if (products != null && products.size() > 0) {
//            for (ProductEntity product : products) {
//                System.out.println(product.toString());
//            }
//        } else {
//            System.out.println("Not Found");
//        }
//    }
//
//    private static void searchByPriceGreater(ProductService productService, double price) {
//        List<ProductEntity> products = productService.searchByPriceGreaterThanEqual(price);
//        if (products != null && products.size() > 0) {
//            for (ProductEntity product : products) {
//                System.out.println(product.toString());
//            }
//        } else {
//            System.out.println("Not Found");
//        }
//    }
//
//    private static void searchByPriceLess(ProductService productService, double price) {
//        List<ProductEntity> products = productService.searchByPriceLessThanEqual(price);
//        if (products != null && products.size() > 0) {
//            for (ProductEntity product : products) {
//                System.out.println(product.toString());
//            }
//        } else {
//            System.out.println("Not Found");
//        }
//    }
//
//    private static void searchByCreateDate(ProductService productService, Date date) {
//        List<ProductEntity> products = productService.searchByCreateDate(date);
//        if (products != null && products.size() > 0) {
//            for (ProductEntity product : products) {
//                System.out.println(product.toString());
//            }
//        } else {
//            System.out.println("Not Found");
//        }
//    }
//
//    private static void searchByCreateDateBetween(ProductService productService, Date timeStart, Date timeEnd) {
//        List<ProductEntity> products = productService.searchByCreateDateBetween(timeStart, timeEnd);
//        if (products != null && products.size() > 0) {
//            for (ProductEntity product : products) {
//                System.out.println(product.toString());
//            }
//        } else {
//            System.out.println("Not Found");
//        }
//    }
}
