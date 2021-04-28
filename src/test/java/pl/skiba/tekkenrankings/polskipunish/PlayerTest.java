package pl.skiba.tekkenrankings.polskipunish;


import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import pl.skiba.tekkenrankings.polskipunish.controlers.PlayerController;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlayerTest {

    PlayerController playerController = mock(PlayerController.class);


    @Test
    public void getPlayers(){
        //given

        //when
        when(playerController.getAll()).thenReturn(testMockData());
        MatcherAssert.assertThat(playerController.getAll(), IsIterableWithSize.iterableWithSize(2));
        //then
    }

    @Test
    public void addPlayer(){
        //given
        Long id = 0L;
        PlayerDTO playerDTO = new PlayerDTO("Crash" , 200 , 0);

        //when
        //given(playerController.findById(id)).willReturn(playerDTO);
        when(playerController.findById(id)).thenReturn(playerDTO);
        PlayerDTO playerDTO2 = playerController.findById(id);
        //then
        Assertions.assertEquals(playerDTO2.getName(), "Crash");
        Assertions.assertNotEquals(playerDTO2.getName(), "Bash");

    }


    @Test(expected = NullPointerException.class)
    public void testNullInput() throws NullPointerException{
        //given
        Long id = 0L;

        //then
        playerController.findById(id).getName();
    }


    private Iterable<PlayerDTO> testMockData(){

        List<pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO> players = new ArrayList<>();
        players.add(new pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO("Crash" , 0 , 50));
        players.add(new pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO("Blau" , 200 , 0));
        return players;

    }

}


