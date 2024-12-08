package additionalTasks.midtermPrepLab.RestaurantManagment;
import java.util.Date;


public class Main {
    public static void main(String[] args){
        Dish tortilla = new Dish("1", "tortilla", 10, CuisineType.MEXICAN, "chicken");
        Dish pizza = new Dish("2", "pizza", 20, CuisineType.ITALIAN, "dough");
        Drink cola = new Drink("3", "coca-cola", 5, 250);
        Drink sprite = new Drink("4", "sprite", 5, 250);

        TableReservation<Dish> reservation1 = new TableReservation<>("1", new Date(), 1);
        reservation1.addItemToOrder(tortilla, 3);
        reservation1.addItemToOrder(pizza,1);
        TableReservation<Drink> reservation2 = new TableReservation<>("1", new Date(), 1);
        reservation2.addItemToOrder(cola, 2);
        reservation2.addItemToOrder(sprite, 2);

        Customer customer1 = new Customer("1","john doe", "000");
        customer1.addReservation(reservation1);
        customer1.addReservation(reservation2);

        Restaurant restaurant = new Restaurant("europa");
        restaurant.addMenuItem(tortilla);
        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(cola);
        restaurant.addMenuItem(sprite);
        restaurant.addCustomer(customer1);

        for(TableReservation<? extends MenuItem> reservation: customer1.getReservations()){
            System.out.println("Customer: " + customer1.getName()+ ", Reservation: " + reservation.getReservationId() +", " + reservation.getReservationDate());
            reservation.displayOrderedItems();
            System.out.println();
        }

        System.out.println(restaurant.calculateTotalSales());
    }
}
