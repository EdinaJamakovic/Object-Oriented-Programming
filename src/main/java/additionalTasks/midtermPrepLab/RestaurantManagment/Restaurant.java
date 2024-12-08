package additionalTasks.midtermPrepLab.RestaurantManagment;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Restaurant {
    private String restaurantName;
    private List<Customer> customers;
    private Map<String, MenuItem> menuItems;

    public Restaurant(String name){
        this.restaurantName = name;
        this.customers = new ArrayList<Customer>();
        this.menuItems = new HashMap<String, MenuItem>();
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void addMenuItem(MenuItem menuItem){
        this.menuItems.put(menuItem.getName(), menuItem);
    }

    public Customer getCustomer(String customerId){
        for(Customer customer: customers){
            if(customer.getCustomerId().equals(customerId))
                return customer;
        }
        return new Customer("-1", "customer doesn't exist", "-1");
    }

    public void displayMenu(){
        for(MenuItem item: menuItems.values()){
            System.out.println(item.getDescription());
        }
    }

    public double calculateTotalSales(){
        double totalSales = 0;
        for(Customer customer: customers){
            for(TableReservation<? extends MenuItem> reservation: customer.getReservations()){
                totalSales += reservation.calculateTotalAmount(0);
            }
        }
        return totalSales;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
