package com.epam.ld.module2.testing.template;


import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class IgnoreNoSuchFileException
        implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context,
                                             Throwable throwable) throws Throwable {

        if (throwable instanceof NoSuchFileException) {
            System.out.println("File not found:" + throwable.getMessage());
            return;
        }
        throw throwable;
    }

}