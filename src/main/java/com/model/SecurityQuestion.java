package com.model;

/**
 * @author Camden Smith
 * This enumeration represents the different security question options.
 */
public enum SecurityQuestion {

    /**
     * Pet name label
     */
    PET_NAME("What was your first pet's name?"),

    /**
     * Mother maiden name label
     */
    MOTHER_MAIDEN_NAME("What is your mother's maiden name?"),

    /**
     * Elementary school label
     */
    ELEMENTARY_SCHOOL("What was the name of your elementary school?");

    /**
     * label String
     */
    private final String label;

    /**
     * Constructor
     * @param label security question label
     */
    private SecurityQuestion(String label) {
        this.label = label;
    }

    /**
     * label accessor
     * @return security question label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * returns an object for each security question
     * @param label label to be returned
     * @return the security question associated with label parameters
     */
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
