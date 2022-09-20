package com.hansol.Board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    String userId;
    String userNm;
    Integer age;
    UserSex sex;
    String regUser;
    Date regTime;
    String editUser;
    Date editTime;
}
