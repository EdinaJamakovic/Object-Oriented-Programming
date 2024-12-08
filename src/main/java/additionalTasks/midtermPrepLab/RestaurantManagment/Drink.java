package additionalTasks.midtermPrepLab.RestaurantManagment;

public class Drink extends MenuItem{
    private double volume;

    public Drink(String code, String name, double price, double volume){
        super(code, name, price);
        this.volume = volume;
    }

    public double getVolume(){
        return this.volume;
    }

    public void setVolume(double volume){
        this.volume = volume;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Volume: " + this.volume;
    }
}
