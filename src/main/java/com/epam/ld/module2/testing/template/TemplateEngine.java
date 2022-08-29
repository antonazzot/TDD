package com.epam.ld.module2.testing.template;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.epam.ld.module2.testing.Client;

public class TemplateEngine {

    public String generateMessage(Template template, Client client) {
        if (checkTeamplate(template)) {
            try {
                readFromFile(template);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return template.getHelloPart() + client.getAddresses() + template.getMiddlePart() + template.getEndPart();
    }

    private boolean checkTeamplate(Template template) {
        return template.getMiddlePart()==null
                ||template.getHelloPart()==null
                ||template.getEndPart()==null
                || template.getHelloPart().isEmpty()
                || template.getMiddlePart().isEmpty()
                || template.getEndPart().isEmpty();
    }

    private Template readFromFile(Template template) throws FileNotFoundException {
        String FILE_FOR_READ = "/Users/Anton_Tsyrkunou/Documents/SomeProject/JMP/TDD/messenger/line.txt";
        File file = new File(FILE_FOR_READ);
        if(!file.exists())
        {
            throw new FileNotFoundException("File not found!");
        }
        try (Scanner sc = new Scanner(file)) {
            template.setHelloPart(sc.nextLine());
            template.setMiddlePart(sc.nextLine());
            template.setEndPart(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return template;
    }

}
