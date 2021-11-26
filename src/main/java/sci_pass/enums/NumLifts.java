package sci_pass.enums;

import lombok.Getter;

import java.util.Arrays;

public enum NumLifts {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    @Getter
    private final int numLifts;

    private NumLifts(int numLifts) {
        this.numLifts = numLifts;
    }
}
