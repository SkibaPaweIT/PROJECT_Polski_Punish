package pl.skiba.tekkenrankings.polskipunish.models.Enums;

import java.util.HashMap;
import java.util.Map;

public enum TournamentPointsEnum {
    Zero(0,0),
    First(1,200),
    Second(2,150),
    Third(3,100),
    Fourth(4,100),
    Fifth(5,60),
    Sixth(6,60),
    Seventh(7,40),
    Eight(8,20),
    Ninth(9,20);



    private int value;
    private int points;
    private static Map map = new HashMap<>();

    TournamentPointsEnum(int value , int points){
        this.value = value;
        this.points = points;
    }

    static {
        for(TournamentPointsEnum tournamentCategoryEnum : TournamentPointsEnum.values()){
            map.put(tournamentCategoryEnum.value, tournamentCategoryEnum);
        }
    }

    public static TournamentPointsEnum valueOf(int tournamentCategoryEnum) {
        return (TournamentPointsEnum) map.get(tournamentCategoryEnum);
    }

    public int getValue() {
        return value;
    }

    public int getPoints() { return points; }
}
