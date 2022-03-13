package pl.skiba.tekkenrankings.polskipunish;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModel;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModelDTO;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PostControllerTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

//    @Test
//    public void testGetAllPosts() throws Exception {
//        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/api/posts"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andReturn();
//
//        PostModel[] postModels= objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PostModel[].class);
//        Assertions.assertEquals("Text here1", postModels[0].getText());
//    }




    public Iterable<PostModelDTO> testMockData() {
        List<PostModelDTO> postModelList = new ArrayList<>();
        PostModel postModel1 = new PostModel("Title1" , "Text here1" , "Link Here1" , true);
        PostModel postModel2 = new PostModel("Title2" , "Text here2" , "Link Here2" , false);
        postModelList.add(SimpleMapper.INSTANCE.PostModelToDto(postModel1));
        postModelList.add(SimpleMapper.INSTANCE.PostModelToDto(postModel2));
        return postModelList;
    }



}
