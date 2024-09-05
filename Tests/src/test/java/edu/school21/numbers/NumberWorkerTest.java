package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import edu.school21.numbers.NumberWorker;

public class NumberWorkerTest {
    NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 101, 103, 821})
    void isPrimeForPrimes(int numb) throws IllegalNumberException {
        assertTrue(numberWorker.isPrime(numb));
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 8, 10, 104, 822})
    void isPrimeForNotPrimes(int numb) throws IllegalNumberException {
        assertFalse(numberWorker.isPrime(numb));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -10, -104, -822})
    void isPrimeForIncorrectNumbers(int numb) {
        IllegalNumberException ex = assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(numb));
        assertEquals("Illegal Argument", ex.getMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void digitSum(int numb, int sum) {
        assertEquals(numberWorker.digitsSum(numb), sum);
    }

}
