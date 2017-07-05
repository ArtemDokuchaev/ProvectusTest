package com.mysoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection getConnetction() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","root");
    }

    public static List<Book> getBooks() throws SQLException, ClassNotFoundException {

        try(Connection c = getConnetction();
            PreparedStatement ps = c.prepareStatement("SELECT author,title,price,id,descripton,genre FROM book");
            ResultSet resultSet = ps.executeQuery();){

            ArrayList<Book> books = new ArrayList<>();
            while(resultSet.next()){
                String author = resultSet.getString(1);
                String title = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int id = resultSet.getInt(4);
                String description = resultSet.getString(5);
                String genre = resultSet.getString(6);
                books.add(new Book(author,title,genre,price,id,description));
            }
            return books;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getBooks());
    }

    public static void addOrder(String firstName, String lastName, String address, int quantity,int bookid) throws SQLException, ClassNotFoundException {
        try(Connection c = getConnetction();
            PreparedStatement ps = c.prepareStatement("INSERT into customer(firstName, lastName, address, quantity, bookID) VALUES (?,?,?,?,?)");){
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, address);
            ps.setInt(4, quantity);
            ps.setInt(5, bookid);
            ps.executeUpdate();
        }
    }

    public static void deletePost(int id) throws SQLException, ClassNotFoundException {

        try(Connection c = getConnetction();
            PreparedStatement ps = c.prepareStatement("DELETE from book WHERE id=?");){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static void addBook(String author, String title, String genre, int price, String descripton) throws SQLException, ClassNotFoundException {

        try(Connection c = getConnetction();
            PreparedStatement ps = c.prepareStatement("INSERT into book(author, title, genre, price, descripton) VALUES (?,?,?,?,?)");){
            ps.setString(1, author);
            ps.setString(2, title);
            ps.setString(3, genre);
            ps.setInt(4, price);
            ps.setString(5, descripton);
            ps.executeUpdate();
        }
    }
}

