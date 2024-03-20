package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository br;

    // 세이브가 없네 만들어야징
    @PostMapping("/board/save")
    public String save(String title, String content, String username){
        br.save(title,content, username);
        return "redirect:/";
    }

    // HttpServletRequest에 담아서 머스테치
    @GetMapping("/" )
    public String index(HttpServletRequest request) {
        List<Board> boardList = br.selectAll();
        request.setAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id) {
        return "board/detail";
    }
}
