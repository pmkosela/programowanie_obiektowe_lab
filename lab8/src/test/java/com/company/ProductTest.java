package com.company;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class ProductTest {

    @Test
    void test1(){
        int year = 2010;
        int month = 3;
        int expected = 2;
        int result = Product.priceIndex(year, month);
        assumeTrue(expected == result);
    }

    @Test
    void shouldThrowException(){
        int year = 2000;
        int month = 4;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Product.priceIndex(year, month);
        });
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(3, 2010, 2),
                Arguments.of(12,2012,35),
                Arguments.of(5,2020,124)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void test2(int month, int year, int expected){
        assertEquals(expected, Product.priceIndex(year,month));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1, delimiter = ';')
    void test3(int month, int year, int expected){
        assertEquals(expected, Product.priceIndex(year,month));
    }

    @Nested
    class GetProductTest {
        @Test
        void test1(){
            int year = 2010;
            int month = 3;
            int expected = 2;
            int result = Product.priceIndex(year, month);
            assumeTrue(expected == result);
        }
    }
}
