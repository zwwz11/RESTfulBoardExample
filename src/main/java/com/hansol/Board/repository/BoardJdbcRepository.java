package com.hansol.Board.repository;

import com.hansol.Board.domain.Board;
import com.hansol.Board.domain.BoardPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<BoardPost> getPostsByBoardId(Integer boardId) {
        return jdbcTemplate.query("" +
                "SELECT * " +
                "FROM TBL_BOARD_POST " +
                "WHERE BOARD_ID = '" + boardId + "'", boardPostRowMapper());
    }

    @Override
    public void saveBoardPost(BoardPost boardPost) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("TBL_BOARD_POST").usingGeneratedKeyColumns("POST_ID");

        Map<String, Object> param = new HashMap<>();
        param.put("BOARD_ID", boardPost.getBoardId());
        param.put("TITLE", boardPost.getTitle());
        param.put("CONTENT", boardPost.getContent());
        param.put("REG_USER", "ADMIN");
        param.put("REG_TIME", LocalDateTime.now());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(param));
    }

    @Override
    public void updateBoardPost(BoardPost boardPost) {
        jdbcTemplate.update("" +
                "UPDATE TBL_BOARD_POST " +
                "   SET TITLE   = ? " +
                "     , CONTENT = ? " +
                "WHERE BOARD_ID = ? " +
                "  AND POST_ID  = ? ", boardPost.getTitle()
                                    , boardPost.getContent()
                                    , boardPost.getBoardId()
                                    , boardPost.getPostId());
    }

    @Override
    public BoardPost getPost(Integer boardId, Integer postId) {
        return jdbcTemplate.query("" +
                "SELECT * " +
                "FROM TBL_BOARD_POST " +
                "WHERE 1=1 " +
                "AND BOARD_ID = '" + boardId + "' " +
                "AND POST_ID = '" + postId + "' ", boardPostRowMapper()).get(0);
    }

    private RowMapper<BoardPost> boardPostRowMapper() {
        return (rs, rowNum) -> {
          BoardPost boardPost = new BoardPost();
          boardPost.setBoardId(rs.getInt("BOARD_ID"));
          boardPost.setPostId(rs.getInt("POST_ID"));
          boardPost.setTitle(rs.getString("TITLE"));
          boardPost.setContent(rs.getString("CONTENT"));
          boardPost.setRegUser(rs.getString("REG_USER"));
          boardPost.setRegTime(rs.getDate("REG_TIME"));
          boardPost.setEditUser(rs.getString("EDIT_USER"));
          boardPost.setEditTime(rs.getDate("EDIT_TIME"));
          return boardPost;
        };
    }

    private RowMapper<Board> boardRowMapper() {
        return (rs, rowNum) -> {
            Board board = new Board();
            board.setBoardId(rs.getInt("BOARD_ID"));
            board.setBoardNm(rs.getString("BOARD_NM"));
            board.setRegUser(rs.getString("REG_USER"));
            board.setRegTime(rs.getDate("REG_TIME"));
            board.setEditUser(rs.getString("EDIT_USER"));
            board.setEditTime(rs.getDate("EDIT_TIME"));
            return board;
        };
    }
}
