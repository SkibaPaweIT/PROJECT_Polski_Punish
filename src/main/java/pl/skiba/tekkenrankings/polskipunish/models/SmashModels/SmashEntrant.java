package pl.skiba.tekkenrankings.polskipunish.models.SmashModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmashEntrant {
    @JsonProperty("name")
    private String name;

    public SmashEntrant(String name) {
        this.name = name;
    }

    public SmashEntrant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
