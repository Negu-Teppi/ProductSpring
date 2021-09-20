package com.manhle.main;

import com.manhle.configuration.SpringConfig;
import com.manhle.entities.*;
import com.manhle.enums.Color;
import com.manhle.enums.Size;
import com.manhle.service.CategoryService;
import com.manhle.service.ColorService;
import com.manhle.service.ProductService;
import com.manhle.service.SizeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductService productService = (ProductService) context.getBean("productService");
        CategoryService categoryService = (CategoryService) context.getBean("categoryService");
        SizeService sizeService = (SizeService) context.getBean("sizeService");
        ColorService colorService = (ColorService) context.getBean("colorService");
//        displayProducts(productService);
//        displayProduct(productService,2);
//        createProduct(4, 2,4, productService, categoryService, colorService,sizeService);
//        updateProduct(4,productService, categoryService,9);
//        deleteProduct(productService, 9);

//        search(productService);
//        searchByCategoryNameAndPrice(productService);
//        searchByColorAndQuanlity(productService);
        searchByColorAndSize(productService);

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

    private static void createProduct(int colorId, int categoryId, int sizeId, ProductService productService,
                                      CategoryService categoryService, ColorService colorService,
                                      SizeService sizeService) {
        CategoryEntity category = categoryService.findCategoryById(categoryId);
        if (category != null) {
            ProductEntity product = new ProductEntity();
            product.setCreateDate(new Date());
            product.setDescription("COMFORTABLE SHORTS FOR RUNS OF ANY DISTANCE.");
            product.setName("OWN THE RUN SHORTS");
            product.setCategory(category);

            ImageEntity image = new ImageEntity();
            image.setName("create image 3");
            image.setProduct(product);

            List<ImageEntity> images = new ArrayList<>();
            images.add(image);
            product.setImages(images);

            ColorEntity color = colorService.findColorById(colorId);
            SizeEntity size = sizeService.findSizeById(sizeId);

            ProductDetailEntity productDetail = new ProductDetailEntity();
            productDetail.setPrice(800000);
            productDetail.setQuantity(2);

            productDetail.setColor(color);
//            if(color!=null){
//                productDetail.setColor(color);
//            }else {
//                System.out.println("Not found color with id: " + colorId);
//            }

            productDetail.setSize(size);
//            if(size!=null){
//                productDetail.setSize(size);
//            }else {
//                System.out.println("Not found size with id: " + size);
//            }
            productDetail.setProduct(product);
            product.setProductDetail(productDetail);

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

    private static void search(ProductService productService) throws ParseException {
        List<ProductEntity> products = productService.searchByNameAndCreateDate("%SQUADRA%",
                new SimpleDateFormat("yyyy/MM/dd").parse("2021/09/01"),
                        new SimpleDateFormat("yyyy/MM/dd").parse("2021/09/30"));
        if (products != null && products.size() > 0) {
            for (ProductEntity product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Not Found");
        }
    }

    private static void searchByCategoryNameAndPrice(ProductService productService) {
        List<ProductEntity> products = productService.searchCategoryNameAndPrice("%or%", 1000000);
        if (products != null && products.size() > 0) {
            for (ProductEntity product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Not Found");
        }
    }

    private static void searchByColorAndQuanlity(ProductService productService) {
        List<ProductEntity> products = productService.searchByColorAndQuanlity(Color.YELLOW, 5);
        if (products != null && products.size() > 0) {
            for (ProductEntity product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Not Found");
        }
    }

    private static void searchByColorAndSize(ProductService productService) {
        List<ProductEntity> products = productService.searchByColorAndSize(Color.YELLOW, Size.XL);
        if (products != null && products.size() > 0) {
            for (ProductEntity product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Not Found");
        }
    }

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
