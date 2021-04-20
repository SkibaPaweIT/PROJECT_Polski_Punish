package pl.skiba.tekkenrankings.polskipunish.modelMappers;

import com.fasterxml.jackson.databind.JsonNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.skiba.tekkenrankings.polskipunish.models.*;
import pl.skiba.tekkenrankings.polskipunish.models.SmashModels.SmashNodes;

import java.util.List;

@Mapper
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);


    //Challonge here
    @Mapping(source="placement" , target="placement")
    @Mapping(source="name" , target="player.name")
    @Mapping(target = "id", ignore = true)
    TournamentParticipant toTournamentParticipantFromChallonge(ChallongeParticipant challongeParticipant);

    @Mapping(source="placement" , target="placement")
    @Mapping(source="player.name" , target="name")

    ChallongeParticipant toChallongeParticipant(TournamentParticipant tournamentParticipant);

    Iterable<ChallongeParticipant> toChallongeParticipants(Iterable<TournamentParticipant> tournamentParticipants);
    Iterable<TournamentParticipant> toTournamentParticipants(Iterable<ChallongeParticipant> tournamentParticipants);
    List<TournamentParticipant> toTournamentParticipantsList(List<ChallongeParticipant> tournamentParticipants);

    //Smash here
    @Mapping(source="placement" , target="placement")
    @Mapping(source="entrant.name" , target="player.name")
    TournamentParticipant toTournamentParticipantFromSmash(SmashNodes smashNodes);

    List<TournamentParticipant> toTournamentParticipantListsFromCSmashNodesList(List<SmashNodes> smashNodesList);


    //CSV
    @Mapping(source="player" , target="player.name")
    @Mapping(source="placement" , target="placement")
    @Mapping(source="points" , target="points")
    TournamentParticipant toTournamentParticipant(CSVTournamentDTO csvTournamentDTO);
    List<TournamentParticipant> toTournamentParticipantsListFromCSV(List<CSVTournamentDTO> tournamentParticipants);

    //Basic DTO conversions

    PlayerDTO PlayerToDTO(Player player);
    Iterable<PlayerDTO> PlayerListToListDTO(List<Player> playerList);

    GameDTO GameToDTO(Game game);
    List<GameDTO> GameListToDTO(List<Game> gameList);


    @Mapping(source="participants" , target="participants")
    @Mapping(source="game" , target="game")
    TournamentDTO TournamentToDto(Tournament tournament);
    Iterable<TournamentDTO> TournamentListToDto(Iterable<Tournament> tournamentList);

    @Mapping(source="player" , target="player")
    TournamentParticipantDTO TournamentParticipantToDto(TournamentParticipant tournamentParticipant);
    List<TournamentParticipantDTO> TournamentParticipantListToDto(List<TournamentParticipant> tournamentParticipantList);


}
