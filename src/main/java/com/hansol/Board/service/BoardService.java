package com.hansol.Board.service;

import com.hansol.Board.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAllBoards();
}
