package entity;

import enums.ProductSeparator;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;
    public final static char PRODUCT_TYPE = 'B';

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    public Boots(int id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;

    }

    public String toString()
    {
        return ProductSeparator.PRODUCT_TYPE_BOOTS.getSign() + ProductSeparator.PRODUCT_SEPARATOR.getSign() + super.getBasicProductToString() + ProductSeparator.PRODUCT_SEPARATOR.getSign() + size + ProductSeparator.PRODUCT_SEPARATOR.getSign() + isNaturalSkin;
    }
}
