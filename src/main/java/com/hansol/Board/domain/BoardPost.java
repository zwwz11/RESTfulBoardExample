package com.hansol.Board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardPost {
    Integer boardId;
    Integer postId;
    String title;
    String content;
    String regUser;
    Date regTime;
    String editUser;
    Date editTime;
}
