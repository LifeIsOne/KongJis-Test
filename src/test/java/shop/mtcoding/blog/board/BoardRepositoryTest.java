package shop.mtcoding.blog.board;

import org.junit.jupiter.api.Test;

public class BoardRepositoryTest {

    private BoardRepository boardRepository;

    @Test
    public void selectById_test(){
        // given
        int id = 1;

        // when
        Board board = boardRepository.selectById(id);

        // then
        System.out.println(board);
    }
}
