package com.epam.ld.module2.testing.template;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class IgnoreFileNotFoundExceptionExtension
        implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context,
                                             Throwable throwable) throws Throwable {
        if (throwable instanceof FileNotFoundException) {
            System.out.println("File not found:" + throwable.getMessage());
            return;
        }
        throw throwable;
    }

}