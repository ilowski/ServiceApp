package tools;

import products.Boots;
import products.Cloth;
import products.Product;
import products.User;

public class Parser {

    public static User convertToUser(String userStr) {
        String userInformations[] = userStr.split(User.USER_SEPARATOR);
        Integer id = Integer.parseInt(userInformations[0]);
        String login = userInformations[1];
        String password = userInformations[2];
        return new User(id, login, password);
    }

    public static String productToString(Product product) {
        return null;
    }

    public static Product stringToProduct(String productStr, String productType) {
        if (productType.equals("PRODUCT")) {
            return convertToProduct(productStr);
        } else if (productType.equals("CLOTH")) {
            return convertToCloth(productStr);
        } else if (productType.equals("Boots")) {
            return convertToBoots(productStr);
        }

        return null;
    }

    public static Product convertToProduct(String productStr) {
        String[] productInformations = productStr.split(Product.PRODUCT_SEPARATOR);
        Integer id = Integer.parseInt(productInformations[0]);
        String productName = productInformations[1];
        Float price = Float.parseFloat(productInformations[2]);
        Float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        Integer productCount = Integer.parseInt(productInformations[5]);
        return new Product(id, productName, price, weight, color, productCount);
    }

    public static Cloth convertToCloth(String productStr) {

        String[] productInformations = productStr.split(Product.PRODUCT_SEPARATOR);
        Integer id = Integer.parseInt(productInformations[0]);
        String productName = productInformations[1];
        Float price = Float.parseFloat(productInformations[2]);
        Float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        Integer productCount = Integer.parseInt(productInformations[5]);
        String size = productInformations[6];
        String material = productInformations[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);

    }

    public static Boots convertToBoots(String productStr) {
        String[] productInformations = productStr.split(Product.PRODUCT_SEPARATOR);
        Integer id = Integer.parseInt(productInformations[0]);
        String productName = productInformations[1];
        Float price = Float.parseFloat(productInformations[2]);
        Float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        Integer productCount = Integer.parseInt(productInformations[5]);
        Integer size = Integer.parseInt(productInformations[6]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInformations[7]);
        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);

    }
}
