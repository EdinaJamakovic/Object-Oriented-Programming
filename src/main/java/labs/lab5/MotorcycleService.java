package labs.lab5;

public enum MotorcycleService {
    LUBRICATE_CHAIN,
    TUNE_ENGINE;
    public String toString() {
        switch (this) {
            case LUBRICATE_CHAIN:
                return "Lubricate chain";
            case TUNE_ENGINE:
                return "Tune Engine";
            default:
                return this.name();
        }
    }
}
