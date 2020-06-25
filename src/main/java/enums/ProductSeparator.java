package enums;

public enum ProductSeparator {

    PRODUCT_SEPARATOR("#"), PRODUCT_TYPE_BOOTS("B"), PRODUCT_TYPE_CLOTH("C"),PRODUCT_TYPE_OTHER("P");
private String sign;
    ProductSeparator(String sign) {
        this.sign = sign;
    }

    public String getSign(){
        return sign;
    }

}
