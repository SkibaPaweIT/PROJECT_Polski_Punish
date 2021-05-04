package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModel;

@Repository
public interface PostRepo extends JpaRepository<PostModel , Long> {

    Iterable<PostModel> findPostModelsByHighlightedEquals(boolean highlighted);
}
