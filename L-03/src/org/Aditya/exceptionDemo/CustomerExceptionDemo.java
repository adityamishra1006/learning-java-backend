package org.Aditya.exceptionDemo;

public class CustomerExceptionDemo {


    public static void main(String[] args) {
        CustomerExceptionDemo c = new CustomerExceptionDemo();
        try {
            c.getByID("2345");
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getByID(String id) throws ProductNotFoundException{

//        ProductNotFoundException e = new ProductNotFoundException("12345", "Does Not Exist");
//        return null;

        {
//            return product;
        }
        throw new ProductNotFoundException("12345", "Does Not Exist");
    }
}
class Product{
    String id;
    String name;

}
