package pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.SmashModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmashNodes {
    @JsonProperty("placement")
    private int placement;
    @JsonProperty("entrant")
    private SmashEntrant entrant;

    public SmashNodes(int placement, SmashEntrant entrant) {
        this.placement = placement;
        this.entrant = entrant;
    }

    public SmashNodes() {
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public SmashEntrant getEntrant() {
        return entrant;
    }

    public void setEntrant(SmashEntrant entrant) {
        this.entrant = entrant;
    }

    public String getPlacementToString() {
        return String.valueOf(placement);
    }
}
