package com.miw.upm.persistence.jdbc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HelloJDBCTest {

    @Test
    public void consumirDBjeeTest() {
        new HelloJDBC().consumirDBjee();
        assertTrue(true);
    }
}
