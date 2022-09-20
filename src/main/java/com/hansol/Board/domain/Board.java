package com.hansol.Board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Board {
    Integer boardId;
    String boardNm;
    String regUser;
    Date regTime;
    String editUser;
    Date editTime;
}
