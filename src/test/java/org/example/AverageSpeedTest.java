package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


    public class AverageSpeedTest {

        @Test
        public void testCalAverageSpeed_NormalCase() {
            double distance = 100.0;
            double time = 20.0;

            double result = AveragSpeed.calAverageSpeed(distance, time);

            assertEquals(5.0, result, 0.0001);
        }

        @Test
        public void testCalAverageSpeed_TimeIsZero_ThrowsException() {
            double distance = 100.0;
            double time = 0.0;

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> AveragSpeed.calAverageSpeed(distance, time)
            );

            assertEquals("zero is not acceptable", exception.getMessage());
        }
}
