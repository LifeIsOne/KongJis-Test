package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public void save(String title, String content, String username){
        String q = """
                INSERT INTO board_tb(title, content, username, created_at)
                VALUES ( ?, ?, ?, now());
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
                """;
        Query query = em.createNativeQuery(q,Board.class);

        return query.getResultList();
    }

}
