package com.hansol.Board.repository;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;

import java.util.List;

public interface BoardRepository {
    List<Board> getAllBoards();
    List<BoardPost> getPostsByBoardId(Integer boardId);
    BoardPost getPost(Integer boardId, Integer postId);
    void saveBoardPost(BoardPost boardPost);
    void updateBoardPost(BoardPost boardPost);
    void deleteBoardPost(Integer boardId, Integer postId);
}
