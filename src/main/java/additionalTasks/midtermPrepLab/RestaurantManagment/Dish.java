package additionalTasks.midtermPrepLab.RestaurantManagment;

public class Dish extends MenuItem{
    CuisineType cuisineType;
    String mainIngredient;

    public Dish(String code, String name, double price, CuisineType cuisineType, String mainIngredient){
        super(code, name, price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    public CuisineType getCuisineType(){
        return this.cuisineType;
    }

    public String getMainIngredient(){
        return this.mainIngredient;
    }

    public void setCuisineType(CuisineType cuisineType){
        this.cuisineType = cuisineType;
    }

    public void setMainIngredient(String mainIngredient){
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription(){
        return
                super.getDescription() +
                ", Cuisine type: " + this.cuisineType +
                ", Main ingredient: " + this.mainIngredient;
    }

}
