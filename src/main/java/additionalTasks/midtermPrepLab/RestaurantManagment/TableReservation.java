package additionalTasks.midtermPrepLab.RestaurantManagment;
import java.util.Date;
import java.util.HashMap;

public class TableReservation<T extends MenuItem>{
    private String reservationId;
    private Date reservationDate;
    private HashMap<T, Integer> orderedItems;
    private int tableNumber;

    public TableReservation(String reservationId, Date reservationDate, int tableNumber){
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        orderedItems = new HashMap<T, Integer>();
    }

    public void addItemToOrder(T item, int quantity){
        if(this.orderedItems.containsKey(item))
            this.orderedItems.put(item, this.orderedItems.get(item) + quantity);
        else
            this.orderedItems.put(item, quantity);
    }

    public double calculateTotalAmount(double discountRate){
        double totalAmount = 0;
        for(T item: orderedItems.keySet()){
            totalAmount += item.applyDiscount(discountRate) * orderedItems.get(item);
        }
        return totalAmount;
    }

    public String getReservationId(){
        return this.reservationId;
    }

    public Date getReservationDate(){
        return this.reservationDate;
    }

    public HashMap<T, Integer> getOrderedItems(){
        return this.orderedItems;
    }

    public void displayOrderedItems(){
        for(T item: this.orderedItems.keySet()){
            System.out.println(item.getDescription()+", Quantity: " + this.orderedItems.get(item));
        }
    }

    public void setOrderedItems(HashMap<T, Integer> orderedItems){
        this.orderedItems = new HashMap<T, Integer>(orderedItems);
    }
}
