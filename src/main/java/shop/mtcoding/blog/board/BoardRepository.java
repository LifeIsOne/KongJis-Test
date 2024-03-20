package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    @Transactional
    public void save(String title, String content, String username){
        String q = """
                INSERT INTO board_tb(title, content, username, created_at)
                VALUES ( ?, ?, ?, now())
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, username);

        query.executeUpdate();
    }

    public List<Board> selectAll(){
        String q = """
                SELECT * FROM board_tb
                ORDER BY id DESC
                """;
        Query query = em.createNativeQuery(q, Board.class);

        return query.getResultList();
    }

    public Board selectById(int id) {
        String q = """
                SELECT * FROM board_tb
                WHERE id = ?
                """;
        Query query = em.createNativeQuery(q, Board.class);
        query.setParameter(1,id);
        return (Board) query.getSingleResult();
    }
    @Transactional
    public void deleteById(int id){
        String q = """
                DELETE FROM board_tb
                WHERE id =?
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1,id);

        query.executeUpdate();
    }

    @Transactional
    public void updateBoard(int id, String title, String content, String username){
        String q = """
                UPDATE board_tb
                SET title = ?, content = ?, username = ?
                WHERE id = ?
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, username);
        query.setParameter(4, id);

        query.executeUpdate();
    }
}
