package pl.skiba.tekkenrankings.polskipunish.exceptions;

public class PlayersNotFoundException extends RuntimeException {

    public PlayersNotFoundException(){
        super("Could not find any players in database");
    }
}
