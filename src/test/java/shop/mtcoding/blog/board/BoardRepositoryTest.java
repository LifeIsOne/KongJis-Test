package shop.mtcoding.blog.board;

import org.junit.jupiter.api.Test;

public class BoardRepositoryTest {

    private BoardRepository br;

    @Test
    public void selectById_test(){
        // given
        int id = 1;

        // when
        Board board = br.selectById(id);

        // then
        System.out.println(board);
    }

    @Test
    public void deleteById_test(){
        // given
        int id = 1;

        // when
        br.deleteById(id);

        // then

    }

    @Test
    public void updateBoard_test(){
        // given
        int id = 1;
        String title = "TITLE";
        String content = "CONTENT";
        String username = "USERNAME";

        // when
        br.updateBoard(id, title, content, username);

        // then
        Board board = br.selectById(id);
        System.out.println(board);
    }
}
