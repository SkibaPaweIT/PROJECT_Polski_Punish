package pl.skiba.tekkenrankings.polskipunish.exceptions;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(String name){
        super("Could not find game with name: " + name);
    }

    public GameNotFoundException(Long id){
        super("Could not find game with id: " + id);
    }
}
