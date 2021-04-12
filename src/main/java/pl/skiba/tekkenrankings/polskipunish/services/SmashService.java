package pl.skiba.tekkenrankings.polskipunish.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.skiba.tekkenrankings.polskipunish.exceptions.TournamentNotFoundException;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.MyModelMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.SmashModels.SmashNodes;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import springfox.documentation.spring.web.json.Json;

import java.util.Arrays;
import java.util.List;

@Service
public class SmashService {


    private ChallongeService challongeService;

    @Autowired
    public SmashService(ChallongeService challongeService) {
        this.challongeService = challongeService;
    }


    @Value("${smash_api_key}")
    private String smash_api_key;
    @Value("${smash_api_url}")
    private String smash_api_url;


    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MyModelMapper myModelMapper = new MyModelMapper();



    GameService gameService;

    public SmashService(GameService gameService) {
        this.gameService = gameService;
    }

    public JsonNode getSmashTournamentFromHttpRequest(String slug, String query) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(smash_api_key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query" , query);
        jsonObject.put("variables", slug);

        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        String jsonStringStr = restTemplate.postForObject(smash_api_url, request , String.class);

        JsonNode node= objectMapper.readTree(jsonStringStr);
        List<JsonNode> check = node.at("/data/tournament").findValues("name");
        if(check.isEmpty())
        {
            throw new TournamentNotFoundException(slug);
        }
        return node;


    }

    public Tournament getTournament(JsonNode root , String tournamentName, TournamentCategoryEnum tournamentType, String gamename) throws JsonProcessingException {

        JsonNode nodesRoot = root.at("/data/tournament/events/0/standings/nodes");
        List<SmashNodes> smashNodesList= Arrays.asList(objectMapper.readValue(nodesRoot.toString(), SmashNodes[].class));
        List<TournamentParticipant> tournamentParticipantList = myModelMapper.modelMapper.map(smashNodesList , new TypeToken<List<TournamentParticipant>>() {}.getType());

        return challongeService.getTourmanetFromParticipantList(tournamentParticipantList, tournamentType,tournamentName, gamename);
    }
}
