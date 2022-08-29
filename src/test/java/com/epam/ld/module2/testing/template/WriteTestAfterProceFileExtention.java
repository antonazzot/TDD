package com.epam.ld.module2.testing.template;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class WriteTestAfterProceFileExtention implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        final String fileName = "/Users/Anton_Tsyrkunou/Documents/SomeProject/JMP/TDD/messenger/testAfterLogs.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        boolean passed = context.getExecutionException().isPresent();
        String result = passed ? "PASSED" : "FAILED";
        printWriter.print("Test Result: " + context.getDisplayName() + " " + result);
        printWriter.close();
    }
}
