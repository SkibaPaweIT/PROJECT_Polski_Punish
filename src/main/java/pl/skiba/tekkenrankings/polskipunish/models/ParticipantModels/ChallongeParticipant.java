package pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChallongeParticipant {

    String name;
    int placement;
    int seed;
    Long id;

    public ChallongeParticipant() {
    }

    public ChallongeParticipant(Long id,String name, int placement) {
        this.id = id;
        this.name = name;
        this.placement = placement;
    }

    public ChallongeParticipant(String name, int placement, int seed, Long id) {
        this.name = name;
        this.placement = placement;
        this.seed = seed;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("final_rank")
    public int getPlacement() {
        return placement;
    }

}
