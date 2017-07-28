/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store;

import java.lang.*;
import java.util.*;

/**
 *
 * @author taranzan
 */
public class Book {

    //Book_store bs = new Book_store();
    String name;
    int price;
    int stock;

    // Not needed
//    Book() {
//        this.name = "";
//        this.price = 0;
//        this.stock = 0;
//    }

    Book(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    void print() {
        System.out.println("Book Name : "+ this.name + " Price : " + this.price + " Stock : " + this.stock);
    }

    int getPrice() {
        return this.price;
    }

}
