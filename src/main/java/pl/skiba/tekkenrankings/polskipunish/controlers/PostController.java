package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModel;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModelDTO;
import pl.skiba.tekkenrankings.polskipunish.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public Iterable<PostModelDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/highlighted")
    public Iterable<PostModelDTO> getAllHighlightedPosts(){
        return postService.getAllHighlightedPosts();
    }


}
