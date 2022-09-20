package com.hansol.Board.domain;

import lombok.val;

public enum UserSex {
    MALE("남자"),
    FEMALE("여자");

    private final String value;

    UserSex(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
