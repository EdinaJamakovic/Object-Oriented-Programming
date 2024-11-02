package labs.lab5;

 public abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;

     /*task unclear, "reducing remaining lifespan" appears throughout task,
     but it isn't specified as an attribute, but to fulfil task, forced to make attribute*/
     private int remainingLifespan;


    public Vehicle(String modelName){
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
        this.remainingLifespan = calculateRemainingLifespan();
    }

    public Vehicle(String modelName, int mileage, int health){
        try{
            this.modelName = modelName;
            this.mileage = mileage;
            this.health = health;
            this.remainingLifespan = calculateRemainingLifespan();
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid health value: " + health);
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
        this.remainingLifespan = this.calculateRemainingLifespan();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if( 0 <= health && health <= 100 ) {
            this.health = health;
        }
        else{
            throw new IllegalArgumentException("Health must be between 0 and 1 (inclusive)");
        }
        this.remainingLifespan = this.calculateRemainingLifespan();
    }

     public int getRemainingLifespan() {
         return remainingLifespan;
     }

     public void setRemainingLifespan(int remainingLifespan) {
         this.remainingLifespan = remainingLifespan;
     }

     public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance(){
        return this.health < 70;
    }

    public int calculateRemainingLifespan(){
        if(this.health >= 50){
            return this.remainingLifespan - this.mileage;
        }
        else {
            return this.remainingLifespan - this.mileage - ((this.expectedLifespan() / 100) * (50 - this.health));
        }
    }

     public void simulateYear() {
         if (this.mileage > this.expectedLifespan() / 2) {
             setHealth(Math.max(0, health - 5));
         }

         this.remainingLifespan = this.calculateRemainingLifespan();
     }

     public static void performMaintenance(Vehicle vehicle) {
         if (vehicle instanceof Car) {
             Car car = (Car) vehicle;
             System.out.println(car.repair()); // Call repair for Car
             car.drive(100); // Drive the car with a specified mileage
         } else if (vehicle instanceof Truck) {
             Truck truck = (Truck) vehicle;
             System.out.println(truck.repair()); // Call repair for Truck
             truck.haul(7000); // Haul with a specified load weight
         } else if (vehicle instanceof Motorcycle) {
             Motorcycle motorcycle = (Motorcycle) vehicle;
             motorcycle.race(50); // Race the motorcycle with specified miles
         }
     }

    @Override
     public String toString(){
         return this.getModelName() + " (Mileage: " + this.getMileage() + ", Health: " + this.getHealth() + ")";
     }
}


