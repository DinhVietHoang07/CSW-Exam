package com.example.dinhviet_hoang.seeder;

import com.example.dinhviet_hoang.entity.Product;
import com.example.dinhviet_hoang.repository.ProductRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
@Slf4j
public class ApplicationSeeder implements CommandLineRunner {
    boolean createSeedData = true;
    final ProductRepository productRepository;


    public ApplicationSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
//        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception{
        if (createSeedData) {
            seedProduct();
        }
    }
    private void seedProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product-01", "On", 1000, 100));
        products.add(new Product("Product-02", "tuyet lắm", 8000, 1090));
        products.add(new Product("Product-03", "tam", 700000, 8200));
        products.add(new Product("Product-04", "hoi on", 300000, 4400));
        products.add(new Product("Product-05", "Không ngon", 200000, 10000));
        productRepository.saveAll(products);
    }

}
