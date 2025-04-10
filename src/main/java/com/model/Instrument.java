package com.model;

/**
 * @author Bradley Alford
 * This enum represents the different instruments that can be used to play a song
 */


public enum Instrument {
    GUITAR("Guitar"),
    STEEL_STRING_GUITAR("Steel String Guitar"),
    ELECTRIC_JAZZ_GUITAR("Electric Jazz Guitar"),
    ELECTRIC_CLEAN_GUITAR("Electric Clean Guitar"),
    ELECTRIC_MUTED_GUITAR("Electric Muted Guitar"),
    OVERDRIVEN_GUITAR("Overdriven Guitar"),
    DISTORTION_GUITAR("Distortion Guitar"),
    ACOUSTIC_BASS("Acoustic Bass"),
    ELECTRIC_BASS_FINGER("Electric Bass Finger"),
    ELECTRIC_BASS_PICK("Electric Bass Pick"),
    FRETLESS_BASS("Fretless Bass"),
    SLAP_BASS_1("Slap Bass"),
    SYNTH_BASS_1("Synth Bass");

    /**
     * label for the instrument
     */
    private final String label;

    /**
     * Constructor for Instrument enum
     * @param label label associated with instrument 
     */
    private Instrument(String label) {
        this.label = label;
    }

    /**
     * static returns Instrument object associated with the label
     * @param label label of the instrument object to be returned
     * @return returns the instrument object associated with the label, null if label does not match any
     */
    public static Instrument getInstrument(String label) {
        if(label.equals(GUITAR.label))
            return GUITAR;
        if(label.equals(STEEL_STRING_GUITAR.label))
            return STEEL_STRING_GUITAR;
        if(label.equals(ELECTRIC_JAZZ_GUITAR.label))
            return ELECTRIC_JAZZ_GUITAR;
        if(label.equals(ELECTRIC_CLEAN_GUITAR.label))
            return ELECTRIC_CLEAN_GUITAR;
        if(label.equals(ELECTRIC_MUTED_GUITAR.label))
            return ELECTRIC_MUTED_GUITAR;
        if(label.equals(OVERDRIVEN_GUITAR.label))
            return OVERDRIVEN_GUITAR;
        if(label.equals(DISTORTION_GUITAR.label))
            return DISTORTION_GUITAR;
        if(label.equals(ACOUSTIC_BASS.label))
            return ACOUSTIC_BASS;
        if(label.equals(ELECTRIC_BASS_FINGER.label))
            return ELECTRIC_BASS_FINGER;
        if(label.equals(ELECTRIC_BASS_PICK.label))
            return ELECTRIC_BASS_PICK;
        if(label.equals(FRETLESS_BASS.label))
            return FRETLESS_BASS;
        if(label.equals(SLAP_BASS_1.label))
            return SLAP_BASS_1;
        if(label.equals(SYNTH_BASS_1.label))
            return SYNTH_BASS_1;
        return null;
    }

}
