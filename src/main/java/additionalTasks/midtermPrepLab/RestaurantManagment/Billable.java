package additionalTasks.midtermPrepLab.RestaurantManagment;

public interface Billable {
    double applyDiscount(double discountRate);
    String getDescription();
}
