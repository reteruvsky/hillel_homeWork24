package com.org.menu;

import com.org.config.Config;
import com.org.entity.Product;
import com.org.service.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    Cart cart;

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        Scanner scanner = new Scanner(System.in);

        Cart cart = context.getBean(Cart.class);

        cart.getProductRepository().getProductList().forEach(System.out::println);

        System.out.println("Application started");
        System.out.println("Press 1 for add a product to the cart");
        System.out.println("Press 2 for delete a product from the cart");
        System.out.println("Press 3 for quit");

        while (true) {
            int index = 0;

            try {
                index = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input data!");
                break;
            }

            switch (index) {
                case 1 -> cart.add(new Product(scanner.nextLong(), scanner.nextLine(), scanner.nextDouble()));
                case 2 -> cart.delete(scanner.nextLong());
                case 3 -> {
                    cart.getProductRepository().getProductList().forEach(System.out::println);
                    return;
                }
                default -> System.out.println("You entered the wrong number!");
            }
        }
    }
}
