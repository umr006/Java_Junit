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
    void isPrimeForPrimes(int numb) {
        assertTrue(numberWorker.isPrime(numb));
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 8, 10, 104, 822})
    void isPrimeForNotPrimes(int numb) {
        assertFalse(numberWorker.isPrime(numb));
    }

}
