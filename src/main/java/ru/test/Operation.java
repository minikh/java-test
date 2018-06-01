package ru.test;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import ru.test.gen.OperationsDateTimeFormatter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Builder
@Getter
public class Operation {
    public final static String DELIMITER = "\t";
    private LocalDateTime date;
    private String pointNumber;
    private long number;
    private BigDecimal amount;

    public String date() {
        return date.format(OperationsDateTimeFormatter.DATE_FORMATTER);
    }

    public static Optional<Operation> create(String line) {
        String[] strings = line.split(Operation.DELIMITER);
        if (strings.length != 5) {
            return Optional.empty();
        }

        LocalDateTime date = LocalDateTime.parse(strings[0] + " " + strings[1], OperationsDateTimeFormatter.DATE_TIME_FORMATTER);
        return Optional.of(Operation.builder()
                .date(date)
                .pointNumber(strings[2])
                .number(Integer.parseInt(strings[3]))
                .amount(new BigDecimal(strings[4]))
                .build());
    }

    public String print() {
        return String.join(DELIMITER,
                date(),
                date.format(OperationsDateTimeFormatter.TIME_FORMATTER),
                pointNumber,
                String.valueOf(number),
                amount.toString(),
                "\n");
    }
}
