package com.edu.unicauca.asae.formatoa_relaciones.enums;

public enum ConceptEnum {
    TO_BE_FIXED("Needs Correction"),  
    REJECTED("Rejected"),  
    APPROVED("Approved"),
    UNESTABLISHED("Unestablished");

    private final String description;

    ConceptEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
