/* task unclear, service method set to "provide" unique services for car,
and repair to return all repairs done, without enum there would be clashes
between available servicing and the repairs done*/

package labs.lab5;

public enum CarService {
    CHANGE_OIL,
    TUNE_ENGINE,
    CHANGE_AIR_FILTER;

    public String toString() {
        switch (this) {
            case CHANGE_OIL:
                return "Change Oil";
            case TUNE_ENGINE:
                return "Tune Engine";
            case CHANGE_AIR_FILTER:
                return "Change Air Filter";
            default:
                return this.name();
        }
    }
}
