package com.epam.ld.module2.testing.template;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.MailServer;
import com.epam.ld.module2.testing.Messenger;

@ExtendWith(IgnoreFileNotFoundExceptionExtension.class)
@ExtendWith(IgnoreNoSuchFileException.class)
@ExtendWith({WriteTestInFileExtention.class, TestWriter.class, WriteTestAfterProceFileExtention.class})
public class TemplateEngineTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void templateEngineTest(String str) {
        Template template = new Template(str, str, str);
        Client client = new Client(str);
        TemplateEngine templateEngine = new TemplateEngine();
        Messenger messenger = new Messenger(new MailServer(), templateEngine);
        messenger.sendMessage(client, template);
        assertThat(templateEngine.generateMessage(template, client)).isEqualTo(str + str + str + str);
    }

    @Test
    @ThisTestWillOnlyRunAtLinuxAndMacWithJava9Or10Or11
    public void templateEngineTest1() {
        Template template = new Template("s", "s", "s");
        Client client = new Client("str");
        Messenger messenger = new Messenger(new MailServer(), new TemplateEngine());
        messenger.sendMessage(client, template);
    }

    @Test
    void givenTestMethodWithTempDirectory_whenWriteToFile_thenContentIsCorrect(@TempDir Path tempDir)
            throws IOException {
        Path message = tempDir.resolve("/Users/Anton_Tsyrkunou/Documents/SomeProject/JMP/TDD/messenger/line.txt");

        List<String> lines = Arrays.asList("x", "y", "z", "a");
        Template template = new Template(lines.get(0), lines.get(2), lines.get(3));
        Client client = new Client(lines.get(1));
        TemplateEngine templateEngine = new TemplateEngine();
        Messenger messenger = new Messenger(new MailServer(), templateEngine);
        messenger.sendMessage(client, template);

        Files.write(message, lines);

        Assertions.assertAll(
                () -> Assertions.assertTrue(Files.exists(message), "File should exist"),
                () -> Assertions.assertLinesMatch(lines, Files.readAllLines(message)));
    }

    @Test
    void testFile() throws Exception {
        String FILE_FOR_READ = "/Users/Anton_Tsyrkunou/Documents/SomeProject/JMP/TDD/messenger/line.txt";
        File mockedFile = mock(File.class, FILE_FOR_READ);
        Mockito.when(mockedFile.exists()).thenReturn(true);
        PowerMockito.whenNew(File.class).withParameterTypes(String.class).withArguments(Matchers.anyString())
                .thenReturn(mockedFile);
        Template template = new Template();
        Client client = new Client("d");
        TemplateEngine templateEngine = new TemplateEngine();
        Messenger messenger = new Messenger(new MailServer(), templateEngine);
        messenger.sendMessage(client, template);

    }

    @Test
    void spyMock() throws Exception {
        TemplateEngine mock = spy(new TemplateEngine());
        String mockStr1 = "1";
        String mockStr2 = "2";
        String mockStr3 = "3";
        Template template = new Template();
        Client client = new Client("d");
        doReturn(mockStr1+mockStr2+mockStr3+"d").when(mock).generateMessage(template, client);
       assertThat(mock.generateMessage(template, client)).isEqualTo(mockStr1+mockStr2+mockStr3+"d");

    }
}
