package labs.lab5;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Car extends Vehicle implements Repairable{
    /* task unclear, adding additional attribute made intuitive sense
    for keeping track of repairs, needed for the repair method*/
    private List<CarService> repairsDone;

    public Car(String modelName) {
        super(modelName);
        this.setRemainingLifespan(expectedLifespan());
        repairsDone = new ArrayList<>();
    }

    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
        this.setRemainingLifespan(calculateRemainingLifespan());
        repairsDone = new ArrayList<>();
    }

    @Override
    public int expectedLifespan() {
        return 150000;
    }

    //Setter for repairsDone attribute
    public void addRepair(CarService repair){
        this.repairsDone.add(repair);
        this.setHealth(this.getHealth() + 10);
    }

    public String repair() {
        if (repairsDone.isEmpty()) {
            return "No repairs done on " + this.getModelName() + ".";
        }

        String repairsString = "";
        if (repairsDone.size() == 1) {
            repairsString += repairsDone.get(0).toString() + " done on " + this;
        } else {
            for (int i = 0; i < repairsDone.size() - 1; i++) {
                repairsString += repairsDone.get(i).toString() + ", ";
            }
            repairsString += "and " + repairsDone.get(repairsDone.size() - 1).toString() + " done on " + this;
        }

        return repairsString;
    }

    public String service(){
        return "Services available for " + this + Arrays.toString(CarService.values());
    }

    public void drive(int miles) {
        this.setMileage(this.getMileage() + miles);
        this.setHealth(this.getHealth() - (int) ((100.0 / this.expectedLifespan()) * miles));
        if(this.getHealth() > 30){
            this.setRemainingLifespan(this.calculateRemainingLifespan()-10000);
        }


    }


}



