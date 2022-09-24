package com.hansol.Board.controller;

import com.hansol.Board.domain.Board;
import com.hansol.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @ModelAttribute("boards")
    private List<Board> boards() {
        log.info("boards = {}", boardService.findAllBoards().stream().count());
        return boardService.findAllBoards();
    }

    @GetMapping("/posts/{boardId}")
    public String getPosts(@PathVariable Integer boardId) {
        log.info("boardId = {}", boardId);
        return "/board/posts";
    }

    @GetMapping("/reg")
    public String getPostReg() {
        return "/board/post-reg";
    }
}
