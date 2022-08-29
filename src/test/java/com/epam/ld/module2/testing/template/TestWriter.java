package com.epam.ld.module2.testing.template;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestWriter implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        final String fileName = "/Users/Anton_Tsyrkunou/Documents/SomeProject/JMP/TDD/messenger/testLogs.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        context.getTestMethod().ifPresent(method -> printWriter.print(method.getName()));
        printWriter.close();
    }
}
