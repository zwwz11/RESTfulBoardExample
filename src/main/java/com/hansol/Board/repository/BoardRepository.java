package com.hansol.Board.repository;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;

import java.util.List;

public interface BoardRepository {
    List<Board> getAllBoards();
    List<BoardPost> getAllBoardPosts();
    void saveBoardPost(BoardPost boardPost);
}
