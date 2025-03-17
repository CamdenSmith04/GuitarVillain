package com.model;

import java.util.EnumSet;

public enum SecurityQuestion {
    PET_NAME("What was your first pet's name?"),
    MOTHER_MAIDEN_NAME("What is your mother's maiden name?"),
    ELEMENTARY_SCHOOL("What was the name of your elementary school?");

    private final String label;

    private SecurityQuestion(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public static void main(String[] args) {
        
        for (SecurityQuestion securityQuestion : EnumSet.allOf(SecurityQuestion.class)) {
            System.out.println(securityQuestion + ": " + securityQuestion.getLabel());
        }
    }

}
