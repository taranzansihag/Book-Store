/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store;

/**
 *
 * @author taranzan
 */
public class Bill {
    //Book_store bs = new Book_store();
    //Book b = new Book();
    String customer_name;
    Book books_name[] = new Book[10];
    int stock;
    int total_ammount ;
    Bill(String customer_name , Book book_name[] , int stock , int ammount){
        this.customer_name = customer_name;
        this.books_name = book_name;
        this.stock = stock;
        this.total_ammount = ammount;        
    }
    void billPrint(){
            System.out.println("Customer Name:" + this.customer_name);
            System.out.print("Books Name : ");
            for(int i=0 ; books_name[i]!=null ; i++){
                System.out.print(this.books_name[i].name+ " , ");
            }
            System.out.println("Total Books:" + this.stock + " Total Ammount Pay:" + this.total_ammount);
}
   
}
