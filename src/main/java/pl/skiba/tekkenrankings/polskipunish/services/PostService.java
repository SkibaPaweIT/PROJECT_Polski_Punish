package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.exceptions.PlayersNotFoundException;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModel;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModelDTO;
import pl.skiba.tekkenrankings.polskipunish.repo.PostRepo;

import javax.persistence.EntityExistsException;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<PostModelDTO> getAllPosts(){
        Iterable<PostModel> postModels =  postRepo.findAll();
        if(((Collection<?>) postModels).size() == 0){
            throw new PlayersNotFoundException();
        }
        return SimpleMapper.INSTANCE.PostModelListToDto(postModels);
    }

    public Iterable<PostModelDTO> getAllHighlightedPosts(){
        Iterable<PostModel> postModels =  postRepo.findPostModelsByHighlightedEquals(true).orElseThrow(EntityExistsException::new);
        return SimpleMapper.INSTANCE.PostModelListToDto(postModels);
    }

    public void savePost(PostModel postModel){
        postRepo.save(postModel);
    }

    public void savePosts(List<PostModel> postModelList){
        postRepo.saveAll(postModelList);
    }



//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        postRepo.save(new PostModel("Title1" , "Text here1" , "Link Here1" , true));
//        postRepo.save(new PostModel("Title2" , "Text here2" , "Link Here2" , true));
//        postRepo.save(new PostModel("Title3" , "Text here3" , "Link Here3" , false));
//        postRepo.save(new PostModel("Title4" , "Text here4" , "Link Here4" , false));
//
//    }

}
