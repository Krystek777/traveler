package com.opitz.model;

import lombok.Getter;

public class TypeOption {

    @Getter
    private String key;
    @Getter
    private String label;

    public TypeOption(ClaimType claimType, String label) {
        this.key = claimType.name();
        this.label = label;
    }

}
