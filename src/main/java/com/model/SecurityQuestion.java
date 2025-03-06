package com.model;

public enum SecurityQuestion {
    PET_NAME("What was your first pet's name?"),
    MOTHER_MAIDEN_NAME("What is your mother's maiden name?"),
    ELEMENTARY_SCHOOL("What was the name of your elementary school?");

    private final String label;

    private SecurityQuestion(String label) {
        this.label = label;
    }

}
