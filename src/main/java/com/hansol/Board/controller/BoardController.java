package com.hansol.Board.controller;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;
import com.hansol.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @ModelAttribute("boards")
    private List<Board> boards() {
        return boardService.findAllBoards();
    }

    @GetMapping("/posts/{boardId}")
    public String getPosts(@PathVariable Integer boardId, Model model) {
        model.addAttribute("posts", boardService.findAllBoardPosts());
        return "/board/posts";
    }

    @GetMapping("/reg/{boardId}")
    public String getPostReg(Model model, @PathVariable Integer boardId) {
        BoardPost boardPost = new BoardPost();
        boardPost.setBoardId(boardId);
        model.addAttribute("post", boardPost);
        return "/board/post-reg";
    }

    @PostMapping("/reg/{boardId}")
    public String postPostReg(@ModelAttribute("post") BoardPost boardPost, @PathVariable Integer boardId) {
        log.info("boardId = {}", boardId);
        log.info("title = {}", boardPost.getTitle());
        log.info("content = {}", boardPost.getContent());
        boardPost.setBoardId(boardId);
        boardService.joinBoardPost(boardPost);
        return "redirect:/board/posts/{boardId}";
    }
}
