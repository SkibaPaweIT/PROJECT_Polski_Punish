package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    String name;
    int onlinePoints = 0;
    int offlinePoints = 0;
    Long challongeId;
    Long smashId;

    public Player() {
    }

    public Player(String name, int onlinePoints, int offlinePoints, Long challongeId, Long smashId) {
        this.name = name;
        this.onlinePoints = onlinePoints;
        this.offlinePoints = offlinePoints;
        this.challongeId = challongeId;
        this.smashId = smashId;
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

    public int getOnlinePoints() {
        return onlinePoints;
    }

    public void setOnlinePoints(int onlinePoints) {
        this.onlinePoints = onlinePoints;
    }

    public int getOfflinePoints() {
        return offlinePoints;
    }

    public void setOfflinePoints(int offlinePoints) {
        this.offlinePoints = offlinePoints;
    }

    public Long getChallongeId() {
        return challongeId;
    }

    public void setChallongeId(Long challongeId) {
        this.challongeId = challongeId;
    }

    public Long getSmashId() {
        return smashId;
    }

    public void setSmashId(Long smashId) {
        this.smashId = smashId;
    }
}
