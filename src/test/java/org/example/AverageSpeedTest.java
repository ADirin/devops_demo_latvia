package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AverageSpeedTest {

    @Test
    void testCalAverageSpeed_NormalCase() {
        double result = AveragSpeed.calAverageSpeed(100.0, 20.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testCalAverageSpeed_TimeIsZero_ThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> AveragSpeed.calAverageSpeed(100.0, 0.0)
        );

        assertEquals("zero is not acceptable", exception.getMessage());
    }
}