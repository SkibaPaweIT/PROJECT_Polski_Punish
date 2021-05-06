package pl.skiba.tekkenrankings.polskipunish.modelMappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.*;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.TournamentFromCSV;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.SmashModels.SmashNodes;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModel;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.PostModelDTO;

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
    TournamentParticipant toTournamentParticipant(TournamentFromCSV csvTournamentDTO);
    List<TournamentParticipant> toTournamentParticipantsListFromCSV(List<TournamentFromCSV> tournamentParticipants);



    //Basic DTO conversions
    PlayerDTO PlayerToDTO(Player player);
    Iterable<PlayerDTO> PlayerListToListDTO(Iterable<Player> playerList);

    @Mapping(source="gameName" , target ="gameName")
    GameDTO GameToDTO(Game game);
    Iterable<GameDTO> GameListToDTO(Iterable<Game> gameList);

    @Mapping(source="participants" , target="participants")
    @Mapping(source="game" , target="game")
    TournamentDTO TournamentToDto(Tournament tournament);
    Iterable<TournamentDTO> TournamentListToDto(Iterable<Tournament> tournamentList);

    @Mapping(source="player" , target="player")
    TournamentParticipantDTO TournamentParticipantToDto(TournamentParticipant tournamentParticipant);
    Iterable<TournamentParticipantDTO> TournamentParticipantListToDto(Iterable<TournamentParticipant> tournamentParticipantList);

    PostModelDTO PostModelToDto(PostModel postModel);
    Iterable<PostModelDTO> PostModelListToDto(Iterable<PostModel> postModelIterable);
}
