public class IncestException extends Exception {
    Person victim, common;

    public IncestException(Person common, Person victim) {
        this.common = common;
        this.victim = victim;
    }

    @Override
    public String toString() {
        return "IncestException{" +
                "victim=" + victim +
                ", common=" + common +
                '}';
    }
}