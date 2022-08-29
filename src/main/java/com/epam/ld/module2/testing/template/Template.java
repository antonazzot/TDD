package com.epam.ld.module2.testing.template;

/**
 * The type Template.
 */
public class Template {
    private String helloPart;
    private String middlePart;
    private String endPart;

    public Template(String helloPart, String middlePart, String endPart) {
        this.helloPart = helloPart;
        this.middlePart = middlePart;
        this.endPart = endPart;
    }

    public Template() {
    }

    public String getHelloPart() {
        return helloPart;
    }

    public void setHelloPart(String helloPart) {
        this.helloPart = helloPart;
    }

    public String getMiddlePart() {
        return middlePart;
    }

    public void setMiddlePart(String middlePart) {
        this.middlePart = middlePart;
    }

    public String getEndPart() {
        return endPart;
    }

    public void setEndPart(String endPart) {
        this.endPart = endPart;
    }
}
