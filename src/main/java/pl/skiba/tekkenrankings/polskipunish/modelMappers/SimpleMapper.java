package pl.skiba.tekkenrankings.polskipunish.modelMappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.skiba.tekkenrankings.polskipunish.models.CSVTournamentDTO;
import pl.skiba.tekkenrankings.polskipunish.models.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;

import java.util.List;

@Mapper
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);

    @Mapping(source="placement" , target="placement")
    @Mapping(source="name" , target="player.name")
    @Mapping(target = "id", ignore = true)
    TournamentParticipant toTournamentParticipant(ChallongeParticipant challongeParticipant);

    @Mapping(source="placement" , target="placement")
    @Mapping(source="player.name" , target="name")

    ChallongeParticipant toChallongeParticipant(TournamentParticipant tournamentParticipant);

    Iterable<ChallongeParticipant> toChallongeParticipants(Iterable<TournamentParticipant> tournamentParticipants);
    Iterable<TournamentParticipant> toTournamentParticipants(Iterable<ChallongeParticipant> tournamentParticipants);
    List<TournamentParticipant> toTournamentParticipantsList(List<ChallongeParticipant> tournamentParticipants);

    //CSV
    @Mapping(source="player" , target="player.name")
    @Mapping(source="placement" , target="placement")
    @Mapping(source="points" , target="points")
    TournamentParticipant toTournamentParticipant(CSVTournamentDTO csvTournamentDTO);
    List<TournamentParticipant> toTournamentParticipantsListFromCSV(List<CSVTournamentDTO> tournamentParticipants);

}
