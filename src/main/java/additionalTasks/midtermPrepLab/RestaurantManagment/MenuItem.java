package additionalTasks.midtermPrepLab.RestaurantManagment;

public abstract class MenuItem implements Billable{
    String code;
    String name;
    double price;

    public MenuItem(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public String getCode(){
        return this.code;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double applyDiscount(double discountRate){
        return this.price * (1-discountRate);
    }

    public String getDescription(){
        return "Name: " + this.name + ", Price: " + this.price;
    }
}
