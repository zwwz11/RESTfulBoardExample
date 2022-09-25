package com.hansol.Board.service;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;

import java.util.List;

public interface BoardService {
    List<Board> findAllBoards();
    List<BoardPost> findAllBoardPosts();
    void joinBoardPost(BoardPost boardPost);
}
