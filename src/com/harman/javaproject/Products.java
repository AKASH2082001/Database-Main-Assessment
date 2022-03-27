package com.harman.javaproject;

import java.sql.*;
import java.util.Scanner;

public class Products{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while (true)
        {
            System.out.println("Select an option :");
            System.out.println("1 . Add an Product ");
            System.out.println("2 . view all Products ");
            System.out.println("3 . Search a product using product  code  ");
            System.out.println("4. Update product details using product Code");
            System.out.println("5. Delete a product  using product Code ");
            System.out.println("6. Display all the details of products  whose price  is greater than 50000");
            System.out.println("7. Display the count of total number of products  in the company");
            System.out.println("8. Display all the product details in alphabetical order");
            System.out.println("9 . Exit");
            option = in.nextInt();
            switch (option) {
                case 1:
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false", "root", "");
                        String product_code, product_name, brand, price, model, year_of_manufacturing, expiry_date;
                        System.out.println("Enter the code :");
                        product_code = in.next();
                        System.out.println("Enter the name :");
                        product_name = in.next();
                        System.out.println("Enter the brand :");
                        brand = in.next();
                        System.out.println("Enter the price :");
                        price = in.next();
                        System.out.println("Enter the model :");
                        model = in.next();
                        System.out.println("Enter the year of manufacturing :");
                        year_of_manufacturing = in.next();
                        System.out.println("Enter the expiry date :");
                        expiry_date = in.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `Products`(`product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacturing`, `expiry_date`) VALUES(" + product_code + ",'" + product_name + "','" + brand + "'," + price + ",'" + model + "'," + year_of_manufacturing + "," + expiry_date + ")");
                        System.out.println("Inserted sucessfully");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View all employees selected");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacturing`, `expiry_date` FROM `Products` WHERE 1");
                        while (rs.next()) {
                            System.out.println("product_code = " + rs.getInt("product_code"));
                            System.out.println("product_name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("year_of_manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("expiry_date = " + rs.getInt("expiry_date"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try
                    {
                        int product_code;
                        System.out.println("Enter the Product Code to be Searched : ");
                        product_code = in.nextInt();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompanydb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `Products` WHERE `product_code`="+product_code);
                        while (rs.next())
                        {
                            System.out.println("product_name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("year_of_manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("expiry date = " + rs.getInt("expiry_date"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try
                    {
                        int product_code;
                        System.out.println("Enter the Product Code to be Updated : ");
                        product_code = in.nextInt();
                        String product_name,brand,price,model,year_of_manufacturing,expiry_date;

                        System.out.println("Enter the Product Name: ");
                        product_name= in.next();
                        System.out.println("Enter the Brand: ");
                        brand= in.next();
                        System.out.println("Enter the Price: ");
                        price= in.next();
                        System.out.println("Enter the Model: ");
                        model= in.next();
                        System.out.println("Enter the Year of Manufacturing: ");
                        year_of_manufacturing= in.next();
                        System.out.println("Enter the Expiry Date: ");
                        expiry_date = in.next();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompanydb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `Products` SET `product_name`='"+product_name+"',`brand`='"+brand+"',`price`="+price+",`model`='"+model+"',`year_of_manufacturing`="+year_of_manufacturing+",`expiry_date`="+expiry_date+" WHERE `product_code`="+product_code);
                        System.out.println("Updated sucessfully");

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 5 :
                    try
                    {
                        int product_code;
                        System.out.println("Enter the Product Code to be Deleted : ");
                        product_code = in.nextInt();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("DELETE FROM `Products` WHERE `product_code`="+product_code);
                        System.out.println("Deleted Sucessfully !!!");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `Products` WHERE `price` > 50000");
                        while (rs.next())
                        {
                            System.out.println("product_code = " + rs.getInt("product_code"));
                            System.out.println("product_name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("year_of_manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("expiry_date = " + rs.getInt("expiry_date"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 7:
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM `Products`");
                        rs.next();
                        int count = rs.getInt(1);
                        System.out.println("The Total Count of the Products = " + count);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 8:
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCDCompanydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `product_code`,`product_name`,`brand`,`price`,`model`,`year_of_manufacturing`,`expiry_date` FROM `products` WHERE 1 order by product_name asc ");
                        while (rs.next())
                        {
                            System.out.println("product_code = " + rs.getInt("product_code"));
                            System.out.println("product_name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("year_of_manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("expiry date = " + rs.getInt("expiry_date"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}