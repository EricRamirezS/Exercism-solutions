import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime finalDate;
    private static final Duration GIGASECOND = Duration.ofSeconds((int)1e9);

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        finalDate = addGigasecond(moment);
    }

    private LocalDateTime addGigasecond(LocalDateTime moment) {
        return moment.plus(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return finalDate;
    }

}
