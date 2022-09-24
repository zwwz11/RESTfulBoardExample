package com.hansol.Board.repository;

import com.hansol.Board.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class BoardJdbcRepository implements BoardRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardJdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Board> getAllBoards() {
        return jdbcTemplate.query("SELECT * FROM TBL_COM_BOARD", boardRowMapper());
    }


    private RowMapper<Board> boardRowMapper() {
        return (rs, rowNum) -> {
            Board board = new Board();
            board.setBoardId(rs.getInt("BOARD_ID"));
            board.setBoardNm(rs.getString("BOARD_NM"));
            board.setRegUser(rs.getString("REG_USER"));
            board.setRegTime(rs.getTime("REG_TIME"));
            board.setEditUser(rs.getString("EDIT_USER"));
            board.setEditTime(rs.getTime("EDIT_TIME"));
            return board;
        };
    }
}
