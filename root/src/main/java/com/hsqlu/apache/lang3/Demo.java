package com.hsqlu.apache.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Demo {
    @Test
    public void printArrayAsString() {
        int[] ints = new int[] {1, 2, 3, 4, 5};
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(ints));
        assertEquals("{1,2,3,4,5}", ArrayUtils.toString(ints));
    }


}
