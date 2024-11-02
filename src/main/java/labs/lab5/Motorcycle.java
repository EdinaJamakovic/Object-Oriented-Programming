package labs.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Motorcycle extends Vehicle {
    private List<MotorcycleService> repairsDone;


    public Motorcycle(String modelName) {
        super(modelName);
        this.setRemainingLifespan(calculateRemainingLifespan());
        repairsDone = new ArrayList<>();
    }

    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
        this.setRemainingLifespan(calculateRemainingLifespan());
        repairsDone = new ArrayList<>();
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }

    @Override
    public String service(){
        return "Services available for " + this + Arrays.toString(CarService.values());
    }

    public void race(int raceMiles) {
        setMileage(getMileage() + raceMiles);
        int newHealth = getHealth() - (int) (raceMiles * 0.2);
        setHealth(Math.max(0, newHealth));

        if (getHealth() < 40) {
            setRemainingLifespan(Math.max(0, calculateRemainingLifespan() - 5000));
        }
    }
}
