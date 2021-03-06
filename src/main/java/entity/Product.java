package entity;

import enums.Color;
import enums.ProductSeparators;

public class Product {

    private int id;
    private String productName;
    private float price;
    private float  weight;
    private Color color;
    private int productCount;
    public final static char PRODUCT_TYPE = 'O';


    public Product(int id, String productName, float price, float weight, Color color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public int getProductCount()
    {
        return productCount;
    }
    public Color getColor()
    {
        return color;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public  float getWeight() {
        return weight;
    }

    public void setPrice(float price)
    {
        this.price=price;
    }

    public void setProductCount (int productCount)
    {
        this.productCount=productCount;
    }

    public String getBasicProductToString() {
        return  id + ProductSeparators.PRODUCT_SEPARATOR.getSign() + productName + ProductSeparators.PRODUCT_SEPARATOR.getSign() + price + ProductSeparators.PRODUCT_SEPARATOR.getSign() + weight + ProductSeparators.PRODUCT_SEPARATOR.getSign() + color + ProductSeparators.PRODUCT_SEPARATOR.getSign() + productCount;
    }

    public String toString() {
        return ProductSeparators.PRODUCT_TYPE_OTHER.getSign() + ProductSeparators.PRODUCT_SEPARATOR.getSign() + getBasicProductToString();
    }
}
