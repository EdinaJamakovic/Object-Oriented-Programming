package labs.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Truck extends Vehicle implements Repairable{
    /* task unclear, adding additional attribute made intuitive sense
    for keeping track of repairs, needed for the repair method*/
    private List<TruckService> repairsDone;

    public Truck(String modelName) {
        super(modelName);
        this.setRemainingLifespan(expectedLifespan());
        this.repairsDone = new ArrayList<>();
    }

    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
        this.setRemainingLifespan(calculateRemainingLifespan());
        repairsDone = new ArrayList<>();
    }

    public String service(){
        return "Services available for " + this + Arrays.toString(TruckService.values());
    }

    public void addRepair(TruckService repair){
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

    @Override
    public int expectedLifespan(){
        return 300000;
    }

    public void haul(int loadWeight){
        if(loadWeight > 5000){
            this.setHealth(this.getHealth()- loadWeight/200);
        }
        if(this.getHealth() < 30){
            this.setRemainingLifespan(this.calculateRemainingLifespan()-20000);
        }
    }

}
