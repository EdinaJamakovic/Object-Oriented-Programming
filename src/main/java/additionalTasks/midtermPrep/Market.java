package additionalTasks.midtermPrep;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

enum HoneyType{
    BAGREMOV,
    LIVADSKI
}

interface Sellable{
    double calculateDiscount(double discountRate); //calculates a discount on the idem price using discount rate
    String getDescription(); //Formatted desc. of the item, w. relevant details
}

abstract class Item implements Sellable{
    private String barcode;
    private String name;
    private double price;

    public Item(String barcode, String name, double price){
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcodde(){
        return this.barcode;
    }

    public String name(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double calculateDiscount(double discountRate){
        return /*this.price -= */ this.price * discountRate;
    }

    public String getDescription(){
        return "Name: " + this.name + "\n" +  "Price: " + this.price;
    }

    @Override
    public String toString(){
        return this.getDescription();
    }
}

class Milk extends Item{
    private double fat;

    public Milk(String barcode, String name, double price, double fat){
        super(barcode, name, price);
        this.fat = fat;
    }

    public double getFat(){
        return this.fat;
    }

    public void setFat(double fat){
        this.fat = fat;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "\nFat: " + this.fat;
    }
}

class Honey extends Item{
    private HoneyType honeyType;

    public Honey(String barcode, String name, double price, HoneyType honeyType){
        super(barcode, name, price);
        this.honeyType = honeyType;
    }

    public HoneyType getHoneyType(){
        return this.honeyType;
    }

    public void setHoneyType(HoneyType honeyType){
        this.honeyType = honeyType;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + "\nHoney type: " + honeyType.name();
    }

}

    class Order<T extends Item>{
        //no need to add "T extends Sellable" because if it extends Item it has to implement sellable
        private String orderNo;
        private Date createAt;
        private HashMap<T, Integer> items;

        public Order(String orderNo, Date createAt, HashMap<T,Integer> items){
            this.orderNo = orderNo;
            this.createAt = createAt;
            this.items = new HashMap<>(items);
        }

        public Order(String orderNo){
            this.orderNo = orderNo;
            this.createAt = new Date();
            this.items = new HashMap<>();
        }

        public String getOrderNo(){
            return this.orderNo;
        }

        public Date getCreateAt(){
            return this.createAt;
        }

        public HashMap<T, Integer> getItems(){
            return this.items;
        }

        public void setOrderNo(String orderNo){
            this.orderNo = orderNo;
        }

        public void setCreateAt(Date createAt){
            this.createAt = createAt;
        }

        public void setItems(HashMap<T, Integer> items){
            this.items = items;
        }

        public void addItem(T item, int quantity){
            if(this.items.keySet().contains(item)) // items.containsKey(item)
                this.items.put(item, this.items.get(item) + quantity);
            else
                this.items.put(item, quantity);
        }

        public double calculateTotalAmount(){
            double total = 0;
            for(T item: items.keySet()){
                total += item.getPrice() * items.get(item);
            }
            return total;
        }

        public String toString(){
            String order = "Order number: " + this.orderNo + "\n";
            for(T item: items.keySet()){
                order += item.toString() + "\nQuantity: " + items.get(item) + "\n";
            }
            return order + "Total Amount: " + this.calculateTotalAmount();
        }

    }

    class Person{
        private String name;
        private int age;
        private List<Order<? extends Item>> orders;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return this.name;
        }

        public int getAge(){
            return this.age;
        }

        public List<Order<? extends Item>> getOrders(){
            return this.orders;
        }

        public void setName(String name){
            this.name = name;
        }

        public void setAge(int age){
            this.age = age;
        }

        public void addOrder(Order<? extends Item> order){
            this.orders.add(order);
        }

        public void setOrders(List<Order<? extends Item>> orders){
            this.orders = orders;
        }

        public void displayOrderInfo(){
            System.out.println("Name: " + this.name + ", Age: " + this.age);
            for(Order<? extends Item> order: orders){
                System.out.println(order);
            }
        }
    }



public class Market {
    public static void main(String[] args) {
        // Step 1: Create instances of Milk and Honey with various attributes
        Milk milk1 = new Milk("MILK001", "Whole Milk", 1.5, 3.5);
        Milk milk2 = new Milk("MILK002", "Skim Milk", 1.2, 0.5);

        Honey honey1 = new Honey("HONEY001", "Organic Honey", 5.0, HoneyType.BAGREMOV);
        Honey honey2 = new Honey("HONEY002", "Wildflower Honey", 4.5, HoneyType.LIVADSKI);

        // Step 2: Create Orders and add items
        Order<Milk> milkOrder = new Order<>("ORDER001");
        milkOrder.addItem(milk1, 2); // Adding 2 units of milk1
        milkOrder.addItem(milk2, 3); // Adding 3 units of milk2

        Order<Honey> honeyOrder = new Order<>("ORDER002");
        honeyOrder.addItem(honey1, 1); // Adding 1 unit of honey1
        honeyOrder.addItem(honey2, 2); // Adding 2 units of honey2

        // Step 3: Create a Person (customer) and add orders
        Person customer = new Person("John Doe", 30);
        List<Order<? extends Item>> orders = new ArrayList<>();
        orders.add(milkOrder);
        orders.add(honeyOrder);
        customer.setOrders(orders);

        // Step 4: Display customer's order history and total amounts
        customer.displayOrderInfo();

    }
}

class Generic<T>{
    T name;

     public void setName(T name){
         this.name = name;
     }

     public T getName(){
         return name;
     }
}
