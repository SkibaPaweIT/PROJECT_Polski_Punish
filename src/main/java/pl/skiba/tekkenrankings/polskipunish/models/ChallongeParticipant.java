package pl.skiba.tekkenrankings.polskipunish.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChallongeParticipant {

    String name;
    int placement;
    Long id;

    public ChallongeParticipant() {
    }

    public ChallongeParticipant(Long id,String name, int placement) {
        this.id = id;
        this.name = name;
        this.placement = placement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("final_rank")
    public int getPlacement() {
        return placement;
    }

    public String getPlacementToString() {
        return String.valueOf(placement);
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

}
