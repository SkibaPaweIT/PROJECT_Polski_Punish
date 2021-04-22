package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

public class PlayerDTO {

    private String name;
    private int onlinePoints=0;
    private int offlinePoints=0;

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
