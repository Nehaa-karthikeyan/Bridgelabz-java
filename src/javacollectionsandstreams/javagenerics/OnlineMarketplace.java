package javacollectionsandstreams.javagenerics;

class Product<T> {
    T category;
    double price;

    Product(T category, double price) {
        this.category = category;
        this.price = price;
    }
}

class DiscountUtil {
    static <T extends Product<?>> void applyDiscount(T product, double percent) {
        product.price -= product.price * percent / 100;
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<String> book = new Product<>("Book", 500);
        DiscountUtil.applyDiscount(book, 10);
        System.out.println("Final Price: " + book.price);
    }
}
