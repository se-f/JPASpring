package org.jee.studentsapp;

import org.jee.studentsapp.entities.Product;
import org.jee.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        productRepository.save(new Product(null, "Computer", 788, 12));
//        productRepository.save(new Product(null, "Printer", 455, 19));
//        productRepository.save(new Product(null, "Smartphone", 588, 25));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> System.out.println(p.toString()));

        Product product = productRepository.findById(Long.valueOf(2)).get();
        System.out.println("**************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("**************");

        System.out.println("-------------");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p -> System.out.println(p.toString()));
        System.out.println("-------------");


        System.out.println("-------------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p -> System.out.println(p.toString()));
        System.out.println("-------------");


        System.out.println("-------------");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(500);
        productList3.forEach(p -> System.out.println(p.toString()));
        System.out.println("-------------");


        System.out.println("-------------");
        List<Product> productList4 = productRepository.searchByPrice(500);
        productList4.forEach(p -> System.out.println(p.toString()));
        System.out.println("-------------");
    }
}
