package com.hansol.Board.controller;

import com.hansol.Board.domain.Board;
import com.hansol.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final BoardService boardService;

    @ModelAttribute("boards")
    private List<Board> boards() {
        return boardService.findAllBoards();
    }

    @GetMapping("/")
    public String home() {
        return "template/home";
    }
}
