package com.hansol.Board.repository;

import com.hansol.Board.domain.Board;

import java.util.List;

public interface BoardRepository {
    List<Board> getAllBoards();
}
