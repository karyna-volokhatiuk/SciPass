package sci_pass.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

public enum Season {
    WINTER(1, 2, 12), SPRING(3, 4, 5), SUMMER(6, 7, 8), AUTUMN(9, 10, 11);

    @Getter
    private final ArrayList<Integer> months = new ArrayList<>();

    private Season(int m1, int m2, int m3) {
        months.add(m1);
        months.add(m2);
        months.add(m3);
    }
}
