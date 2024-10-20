public class PlayerRecord {
    private String name;
    private String position;
    private String teamName;
    private int gamesPlayed;
    private int goalsScored;
    private int assists;
    private int penaltyMinutes;
    private int shotsOnGoal;
    private int gameWinningGoals;

    public PlayerRecord(String name, String position, String teamName, String gamesPlayed, String goalsScored,
                        String assists, String penaltyMinutes, String shotsOnGoal, String gameWinningGoals) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = Integer.parseInt(gamesPlayed);
        this.goalsScored = Integer.parseInt(goalsScored);
        this.assists = Integer.parseInt(assists);
        this.penaltyMinutes = Integer.parseInt(penaltyMinutes);
        this.shotsOnGoal = Integer.parseInt(shotsOnGoal);
        this.gameWinningGoals = Integer.parseInt(gameWinningGoals);
    }

    public String getName() {
        return name;
    }

    public int getAssists() {
        return assists;
    }

    public int getPenaltyMinutes() {
        return penaltyMinutes;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGameWinningGoals() {
        return gameWinningGoals;
    }

    public int getGoalsScored() {
        return goalsScored;
    }


    public int getShotsOnGoal() {
        return shotsOnGoal;
    }

    public String getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return "PlayerRecord{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", teamName='" + teamName + '\'' +
                ", gamesPlayed='" + gamesPlayed + '\'' +
                ", goalsScored='" + goalsScored + '\'' +
                ", assists='" + assists + '\'' +
                ", penaltyMinutes='" + penaltyMinutes + '\'' +
                ", shotsOnGoal='" + shotsOnGoal + '\'' +
                ", gameWinningGoals='" + gameWinningGoals + '\'' +
                '}';
    }
}
