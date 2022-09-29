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

    @GetMapping("{boardId}/posts")
    public String getPosts(@PathVariable Integer boardId, Model model) {
        model.addAttribute("posts", boardService.findPostsByBoardId(boardId));
        return "/board/posts";
    }

    @GetMapping("/{boardId}/posts/reg")
    public String getPostReg(Model model, @PathVariable Integer boardId) {
        BoardPost boardPost = new BoardPost();
        boardPost.setBoardId(boardId);
        model.addAttribute("post", boardPost);
        return "/board/post-reg";
    }

    @PostMapping("/{boardId}/posts/reg")
    public String postPostReg(@ModelAttribute("post") BoardPost boardPost, @PathVariable Integer boardId) {
        boardPost.setBoardId(boardId);
        boardService.joinBoardPost(boardPost);
        return "redirect:/board/{boardId}/posts";
    }

    @GetMapping("/{boardId}/posts/{postId}")
    public String getPostEdit(Model model, @PathVariable Integer boardId, @PathVariable Integer postId) {
        BoardPost boardPost = boardService.findPost(boardId, postId);
        model.addAttribute("post", boardPost);
        return "/board/post-edit";
    }

    @PutMapping("/{boardId}/posts/{postId}")
    public String putPostEdit(@ModelAttribute("post") BoardPost boardPost) {
        boardService.editBoardPost(boardPost);
        return "redirect:/board/{boardId}/posts";
    }

    @DeleteMapping("/{boardId}/posts/{postId}")
    public String deletePostEdit(@PathVariable Integer boardId, @PathVariable Integer postId) {
        boardService.removeBoardPost(boardId, postId);
        return "redirect:/board/{boardId}/posts";
    }
}
