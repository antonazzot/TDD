package com.epam.ld.module2.testing.template;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class WriteTestInFileExtention implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        final String fileName = "/Users/Anton_Tsyrkunou/Documents/SomeProject/JMP/TDD/messenger/testLogs.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(context.getDisplayName());
        printWriter.close();
    }
}
