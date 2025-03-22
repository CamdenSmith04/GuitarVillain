package com.model;

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

    public static SecurityQuestion getSecurityQuestion(String label) {
        if (label.equals(PET_NAME.label)){
            return PET_NAME;
        }
        if (label.equals(MOTHER_MAIDEN_NAME.label)){
            return MOTHER_MAIDEN_NAME;
        }
        if (label.equals(ELEMENTARY_SCHOOL.label)){
            return ELEMENTARY_SCHOOL;
        }
        return null;
    }

}
