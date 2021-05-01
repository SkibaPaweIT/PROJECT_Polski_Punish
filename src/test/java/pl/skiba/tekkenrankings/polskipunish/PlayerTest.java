package pl.skiba.tekkenrankings.polskipunish;


import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import pl.skiba.tekkenrankings.polskipunish.controlers.PlayerController;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlayerTest {

    PlayerController playerController = mock(PlayerController.class);


    @Test
    public void testPlayerGetOfflineRanking(){

        Iterable<OfflineRanking> offlineRankings = new ArrayList<>();
        when(playerController.getOfflineRanking()).thenReturn(offlineRankings);

        MatcherAssert.assertThat(playerController.getOfflineRanking(), IsIterableWithSize.iterableWithSize(0));
    }

    @Test
    public void testPlayerGetOnlineRanking(){

        Iterable<OnlineRanking> onlineRankings = new ArrayList<>();
        when(playerController.getOnlineRanking()).thenReturn(onlineRankings);

        MatcherAssert.assertThat(playerController.getOnlineRanking(), IsIterableWithSize.iterableWithSize(0));
    }

    @Test
    public void testPlayerAddPlayer(){
        //given
        Long id = 0L;
        PlayerDTO playerDTO = new PlayerDTO("Crash" , 200 , 0);

        //when
        //given(playerController.findById(id)).willReturn(playerDTO);
        when(playerController.findById(id)).thenReturn(playerDTO);
        PlayerDTO playerDTO2 = playerController.findById(id);
        //then
        Assertions.assertEquals(playerDTO2.getName(), playerDTO.getName());
        Assertions.assertNotEquals(playerDTO2.getName(), playerDTO.getName());

    }

    @Test(expected = NullPointerException.class)
    public void testPlayerNullInput() throws NullPointerException{
        //given
        Long id = 0L;

        //then
        playerController.findById(id).getName();
    }



    @Test
    public void testPlayerGetPlayers(){

        when(playerController.getAll()).thenReturn(testMockData());
        MatcherAssert.assertThat(playerController.getAll(), IsIterableWithSize.iterableWithSize(2));
    }

    private Iterable<PlayerDTO> testMockData(){
        List<pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO> players = new ArrayList<>();
        players.add(new pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO("Crash" , 0 , 50));
        players.add(new pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO("Blau" , 200 , 0));
        return players;

    }



}


