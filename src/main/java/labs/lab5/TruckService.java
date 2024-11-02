package labs.lab5;

public enum TruckService {
    OVERHAUL_ENGINE,
    REPLACE_TIRES;

    public String toString() {
        switch (this) {
            case OVERHAUL_ENGINE:
                return "Overhaul engine";
            case REPLACE_TIRES:
                return "Replace tires";
            default:
                return this.name();
        }
    }
}
