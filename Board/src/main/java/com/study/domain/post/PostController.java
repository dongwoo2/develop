package com.study.domain.post;

import com.study.common.dto.MessageDto;
import com.study.common.dto.SearchDto;
import com.study.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write.do") //requestparam 화면에서 보낸 파라미터를 전달받는 데 사용됨
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write";
    }
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params, Model model){
        postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return "redirect:/post/list.do";
    }

    @GetMapping("/post/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> response = postService.findAllPost(params);
        model.addAttribute("response", response);
        return "post/list";
    }

    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post/view";
    }

    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params , Model model) {
        postService.updatePost(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다. " ,"/post/list.do",
                RequestMethod.GET, null);
        return "redirect:/post/list.do";
    }

    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final long id, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return "redirect:/post/list.do";
    }

    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}