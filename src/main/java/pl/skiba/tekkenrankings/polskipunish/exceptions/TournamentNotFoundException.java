package pl.skiba.tekkenrankings.polskipunish.exceptions;

public class TournamentNotFoundException extends RuntimeException {

    public TournamentNotFoundException(long id){
        super("Could not found Tournament with id: " + id);
    }

    public TournamentNotFoundException(String url){
        super("Could not found Challonge Tournament with name: " + url);
    }
}
