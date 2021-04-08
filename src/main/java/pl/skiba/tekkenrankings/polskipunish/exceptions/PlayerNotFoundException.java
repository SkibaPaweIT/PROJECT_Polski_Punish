package pl.skiba.tekkenrankings.polskipunish.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(long id){
        super("Could not found Player with id: " + id);
    }
}
