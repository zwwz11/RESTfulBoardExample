package com.hansol.Board.service;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;
import com.hansol.Board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public List<Board> findAllBoards() {
        return boardRepository.getAllBoards();
    }

    @Override
    public List<BoardPost> findAllBoardPosts() {
        return boardRepository.getAllBoardPosts();
    }

    @Override
    public void joinBoardPost(BoardPost boardPost) {
        boardRepository.saveBoardPost(boardPost);
    }
}
