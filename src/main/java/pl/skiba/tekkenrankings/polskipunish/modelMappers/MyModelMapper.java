package pl.skiba.tekkenrankings.polskipunish.modelMappers;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import pl.skiba.tekkenrankings.polskipunish.models.CSVTournamentDTO;
import pl.skiba.tekkenrankings.polskipunish.models.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.models.SmashModels.SmashNodes;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;

public class MyModelMapper {

    public ModelMapper modelMapper;

    public MyModelMapper() {
        this.modelMapper = new ModelMapper();
        modelMapper.addConverter(CSVParticipantToTournamentParticipant);
        modelMapper.addConverter(ChallongeParticipantToTournamentParticipant);
        modelMapper.addConverter(SmashNodeToTournamentParticipant);
    }

    Converter<CSVTournamentDTO, TournamentParticipant> CSVParticipantToTournamentParticipant = new Converter<>() {
        public TournamentParticipant convert(MappingContext<CSVTournamentDTO, TournamentParticipant> context) {
            TournamentParticipant tournamentParticipant = new TournamentParticipant();
            tournamentParticipant.setPlayer(new Player(context.getSource().getPlayer()));
            tournamentParticipant.setPlacement(context.getSource().getPlacement());
            //tournamentParticipant.setPoints(context.getSource().getPoints());
            return tournamentParticipant;
        }
    };

    Converter<ChallongeParticipant, TournamentParticipant> ChallongeParticipantToTournamentParticipant = new Converter<>() {
        @Override
        public TournamentParticipant convert(MappingContext<ChallongeParticipant, TournamentParticipant> mappingContext) {
            TournamentParticipant tournamentParticipant = new TournamentParticipant();
            tournamentParticipant.setPlayer(new Player(mappingContext.getSource().getName()));
            tournamentParticipant.setPlacement(mappingContext.getSource().getPlacement());
            return tournamentParticipant;
        }
    };

    Converter<SmashNodes, TournamentParticipant> SmashNodeToTournamentParticipant = new Converter<>() {
        @Override
        public TournamentParticipant convert(MappingContext<SmashNodes, TournamentParticipant> mappingContext) {
            TournamentParticipant tournamentParticipant = new TournamentParticipant();
            tournamentParticipant.setPlacement(mappingContext.getSource().getPlacement());
            tournamentParticipant.setPlayer(new Player(mappingContext.getSource().getEntrant().getName()));
            return tournamentParticipant;
        }
    };

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
