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
    private Long id;
    private String name;
    private int onlinePoints=0;
    private int offlinePoints=0;

    public Player() {
    }

    public Player(String name, int onlinePoints, int offlinePoints) {
        this.name = name;
        this.onlinePoints = onlinePoints;
        this.offlinePoints = offlinePoints;
    }

    public Player(String name) {
        this.name = name;
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
}
