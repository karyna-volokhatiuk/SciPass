package sci_pass.enums;

import lombok.Getter;

public enum NumDays {
    ONE_DAY(1), TWO_DAYS(2), FIVE_DAYS(5);

    @Getter
    private final int numDays;

    private NumDays(int numDays) {
        this.numDays = numDays;
    }
}
