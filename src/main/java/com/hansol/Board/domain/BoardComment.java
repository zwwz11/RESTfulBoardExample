package com.hansol.Board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardComment {
    Integer boardId;
    Integer postId;
    Integer commentId;
    String content;
    String regUser;
    Date regTime;
    String editUser;
    Date editTime;
}
