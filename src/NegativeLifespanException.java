import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class NegativeLifespanException extends DateTimeException {
    final public Period lifespan;


    public NegativeLifespanException(LocalDate birth, LocalDate death, String message) {
        super(message);
        lifespan = Period.between(birth, death);
    }
}