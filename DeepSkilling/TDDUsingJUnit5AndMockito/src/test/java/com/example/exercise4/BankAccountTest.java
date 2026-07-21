package com.example.exercise4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
        System.out.println("Setup completed");
    }

    @Test
    void testDeposit() {

        // Arrange
        double amount = 500;

        // Act
        account.deposit(amount);

        // Assert
        assertEquals(1500, account.getBalance());
    }

    @AfterEach
    void tearDown() {
        account = null;
        System.out.println("Teardown completed");
    }
}