package com.hansol.Board.service;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;

import java.util.List;

public interface BoardService {
    List<Board> findAllBoards();
    List<BoardPost> findPostsByBoardId(Integer boardId);
    BoardPost findPost(Integer boardId, Integer postId);
    void joinBoardPost(BoardPost boardPost);
    void editBoardPost(BoardPost boardPost);
    void removeBoardPost(Integer boardId, Integer postId);
}
