package additionalTasks.midtermPrepLab.Tasks1;
import java.util.List;
import java.util.ArrayList;

@FunctionalInterface
interface DiscountStrategy{
    double applyDiscount(double price);
}

@FunctionalInterface
interface BulkDiscountStrategy{
    double applyBulkDiscount(double price, int quantity);
}

class Product{
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

class DiscountStrategies{
    public static DiscountStrategy percentageDiscount = (double price) -> price * 0.75;
    public static DiscountStrategy fixedDiscount = (double price) -> price - 10;
    public static BulkDiscountStrategy bulkDiscount = (double price, int quantity) -> quantity > 10 ? price * 0.75: price;

    public static double applyDiscount(List<Product> products){
        double discountedPrice = 0;
        for(Product product: products) {
            discountedPrice += percentageDiscount.applyDiscount(product.getQuantity()*product.getPrice());
        }
        return discountedPrice;
    }
}

public class ECommerceDsicountEngine {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("milk", 10, 4));
        products.add(new Product("honey", 100, 3));
        System.out.println(DiscountStrategies.applyDiscount(products));
    }
}
