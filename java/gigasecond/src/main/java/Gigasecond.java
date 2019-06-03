import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime finalDate;
    private static final Duration GIGASECOND = Duration.ofSeconds(1_000_000_000);

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        finalDate = moment.plus(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return finalDate;
    }
}