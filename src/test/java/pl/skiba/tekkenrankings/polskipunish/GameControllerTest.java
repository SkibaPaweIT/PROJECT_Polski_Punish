package pl.skiba.tekkenrankings.polskipunish;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.skiba.tekkenrankings.polskipunish.controlers.GameController;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.GameDTO;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class GameControllerTest {

    GameController gameController = mock(GameController.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOK() throws Exception{

        this.mockMvc.perform(get("/api/games")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testPlayerGetPlayers(){
        //given
        //when
        when(gameController.getAllGames()).thenReturn(testMockData());

        //then
        MatcherAssert.assertThat(gameController.getAllGames(), IsIterableWithSize.iterableWithSize(2));
    }

    private Iterable<GameDTO> testMockData(){

        List<GameDTO> games = new ArrayList<>();
        games.add(new GameDTO());
        games.add(new GameDTO());
        return games;

    }
}
