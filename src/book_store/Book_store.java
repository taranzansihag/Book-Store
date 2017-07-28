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
public class Book_store {

    Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    Book books[] = new Book[10000];
    Bill bills[] = new Bill[10000];
    String bs_name;
    int position = 0;
    int bill_position = 0;

    Book_store(String name) {
        this.bs_name = name;
    }

    Book checkBook(String name) {
        for (int i = 0; i < position; i++) {
            if (name.equals(books[i].name)) {
                return books[i];
            }
        }
        return null;
    }

    Book getBook() {
        System.out.print("Enter name of Book: ");
        String name = sc.next();
        Book b = checkBook(name);
        if (b == null) {
            System.out.print("Enter price of Book: ");
            int price = sc.nextInt();
            System.out.print("Enter stock of " + name + " Book :");
            int stock = sc.nextInt();
            return new Book(name, price, stock);
        } else {

            System.out.println("Sorry ! This book allready available");
            System.out.print("enter any key : ");
            sc.next();
            return null;
        }
    }

    void addBook(Book b) {
        books[position] = b;
        position++;
    }

    void printAll() {
        for (int i = 0; i < position; i++) {
            books[i].print();
        }
        System.out.print("enter any key : ");
        sc.next();
    }

    void findBook() {
        System.out.print("Enter name of Book: ");
        String name = sc.next();
        Book b = checkBook(name);
        if (b != null) {
            b.print();
            System.out.print("enter any key : ");
            sc.next();
        } 
        else {
            System.out.println("Sorry! " + name + " book is not available");
            System.out.print("enter any key : ");
            sc.next();
        }
    }

    Bill getBill() {
        int book_pos = 0;
        boolean input = true;
        int ch;
        int total_ammount = 0;
        int stock = 0;
        Book book_name[] = new Book[1000];
        System.out.print("Enter Customer name: ");
        String customer_name = sc.next();
        while (input) {
            System.out.print("Enter Book name : ");
            String name = sc.next();
            System.out.print("Enter number of books : ");
            int num_book = sc.nextInt();
            Book b = checkBook(name);

            if (b != null && b.stock >= stock) {
                book_name[book_pos] = b;
                book_pos++;
                b.stock -= num_book;
                stock += num_book;
                total_ammount += stock * b.price;
                System.out.print("Enter key 0 to exit and any other to add more books : ");
                ch = sc.nextInt();
                if (ch == 0) {
                    return new Bill(customer_name, book_name, stock, total_ammount);
                }

            } else {
                System.out.println("Sorry! This book is not available in stock");
                System.out.print("Enter key 0 to exit and any other to add more books : ");
                ch = sc.nextInt();
                if (ch == 0) {
                    return new Bill(customer_name, book_name, stock, total_ammount);
                }
            }

        }
        return null;
    }

    void addBill(Bill b1) {
        bills[bill_position] = b1;
        bill_position++;

    }

    void printAllBill() {
        for (int i = 0; i < bill_position; i++) {
            bills[i].billPrint();
        }
        System.out.print("enter any key : ");
        sc.next();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Book Store Name :");
        String bs_name = sc.next();
        Book_store bs = new Book_store(bs_name);
        boolean input = true;
        while (input) {
            System.out.println("0.Exit");
            System.out.println("1.Add new book");
            System.out.println("2.Print all book");
            System.out.println("3.Bill");
            System.out.println("4.Print all bills");
            System.out.println("5.Find Books");
            System.out.print("Enter Your choice : ");
            int choose = sc.nextInt();
            switch (choose) {
                case 0: {
                    input = false;
                    break;
                }
                case 1: {

                    Book b = bs.getBook();
                    if (b != null) {
                        bs.addBook(b);
                    }
                    break;

                }
                case 2: {
                    bs.printAll();
                    break;
                }
                case 3: {
                    Bill bl = bs.getBill();
                    bs.addBill(bl);
                    break;
                }
                case 4: {
                    bs.printAllBill();
                    break;
                }
                case 5: {
                    bs.findBook();
                    break;
                }
                default: {
                    System.out.println("please choose b/w choice");
                    System.out.print("enter any key : ");
                    sc.next();
                }
            }
        }

    }

}
