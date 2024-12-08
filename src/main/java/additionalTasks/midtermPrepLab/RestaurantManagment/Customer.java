package additionalTasks.midtermPrepLab.RestaurantManagment;
import java.util.List;
import java.util.ArrayList;


public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private List<TableReservation<? extends MenuItem>> reservations;

    public Customer(String customerId, String name, String phoneNumber){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<TableReservation<? extends MenuItem>>();
    }

    public void addReservation(TableReservation<? extends MenuItem> reservation){
        this.reservations.add(reservation);
    }

    public List<TableReservation<? extends MenuItem>> getReservations(){
        return this.reservations;
    }

    public void setReservations(List<TableReservation<? extends MenuItem>> reservations){
        this.reservations = reservations;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


