package com.edu.unicauca.asae.formatoa_relaciones.enums;


public enum StateEnum {
    FORMULATED("Formulated"),  
    UNDER_REVIEW("Under Evaluation"),  
    TO_BE_FIXED("Needs Correction"),  
    REJECTED("Rejected"),  
    APPROVED("Approved");  

    private final String description;

    StateEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
