package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = {
                new Product("3128874119", "Banana", "2023-01-24", 124, 0.55),
                new Product("2927458265", "Apple", "2022-12-09", 18, 1.09),
                new Product("9189927460", "Carrot", "2023-03-31", 89, 2.99),
        };
        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        List<Product> sortedProducts = Arrays.stream(products).sorted(Comparator.comparing(Product::getName)).toList();
        printJSON(sortedProducts);
        System.out.println("------------------------------------");
        printXML(sortedProducts);
        System.out.println("------------------------------------");
        printCSV(sortedProducts);
    }

    public static void printJSON(List<Product> sortedProducts) {
        System.out.println("Printed in JSON Format");
        System.out.println("[");
        for (Product product : sortedProducts) {
            System.out.println("{ \"productId\":" + product.getProductId() + ", \"name\":" + product.getName() + ", \"dateSupplied\":" + product.getDateSupplied() + ", \"quantityInStock\":" + product.getQuantityInStock() + ", \"unitPrice\":" + product.getUnitPrice() + "  },");
        }
        System.out.println("]");
    }

    public static void printXML(List<Product> sortedProducts) {
        System.out.println("Print XML Format");
        System.out.println("<?xml version=\"1.0\"");
        System.out.println("<products>");
        for (Product product : sortedProducts) {
            System.out.println("<product productId=\"" + product.getProductId() + "\" name=\"" + product.getName() + "\" dateSupplied=\"" + product.getDateSupplied() + "\" quantityInStock=\"" + product.getQuantityInStock() + "\" unitPrice=\"" + product.getUnitPrice() + "\"/>");
        }
        System.out.println("</products>");
    }

    public static void printCSV(List<Product> sortedProducts) {
        System.out.println("Print Comma-Seperated Value - CSV Format");
        for (Product product : sortedProducts) {
            System.out.println(product.getProductId() + ", " + product.getName() + ", " + product.getDateSupplied() + ", " + product.getQuantityInStock() + ", " + product.getUnitPrice());
        }
    }
}