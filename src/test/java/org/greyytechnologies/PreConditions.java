package org.greyytechnologies;

import net.thucydides.model.reports.adaptors.xunit.model.TestException;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class PreConditions
{
    @BeforeClass
    public static void startup() throws TestException {
        if (androidDriver == null) {
            executionBlock();
            System.out.println("Driver has been started successfully");
        } else
            throw new TestException("There is an existing driver!");
    }

    @AfterClass
    public static void teardown() throws TestException {
        if (androidDriver != null) {
            quitDriver();
        } else {
            throw new TestException("Driver has not been started ");
        }
    }
}
