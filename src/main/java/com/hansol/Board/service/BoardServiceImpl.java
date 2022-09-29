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
    public List<BoardPost> findPostsByBoardId(Integer boardId) {
        return boardRepository.getPostsByBoardId(boardId);
    }

    @Override
    public BoardPost findPost(Integer boardId, Integer postId) {
        return boardRepository.getPost(boardId, postId);
    }

    @Override
    public void joinBoardPost(BoardPost boardPost) {
        boardRepository.saveBoardPost(boardPost);
    }

    @Override
    public void editBoardPost(BoardPost boardPost) {
        boardRepository.updateBoardPost(boardPost);
    }

    @Override
    public void removeBoardPost(Integer boardId, Integer postId) {
        boardRepository.deleteBoardPost(boardId, postId);
    }
}
