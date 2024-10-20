public class NHLStats {
    private List<PlayerRecord> stats;

    public NHLStats(){
        stats  = new List<PlayerRecord>();
    }

    //add function
    public void add(PlayerRecord player){
        stats.add(player);
    }
    //get length
    public int length(){
        return stats.size();
    }

    //get first
    public  PlayerRecord getFirst() {
        return stats.first() ;
    }
    //get next
    public  PlayerRecord getNext(PlayerRecord player) {
        return stats.next() ;
    }
    //Display the name and team name for the player with the most points (Goals+Assists).
    //Note: If more than one player had the greatest number of points, display all the players and their teams.

    public String mostPoint(){
        String bestPlayerAndTeam = " ";
        PlayerRecord currentPlayer = getFirst();
        int highest = 0;
        //search for best player or players with most points
        for(int i = 0; i<stats.size();i++){
            if(currentPlayer.getAssists()+ currentPlayer.getGoalsScored() > highest){
                bestPlayerAndTeam = currentPlayer.getName() + " " + currentPlayer.getTeamName();
                highest =currentPlayer.getAssists()+ currentPlayer.getGoalsScored();
            } else if (currentPlayer.getAssists()+ currentPlayer.getGoalsScored() == highest) {
                bestPlayerAndTeam = bestPlayerAndTeam + ", " +currentPlayer.getName() + " " + currentPlayer.getTeamName() + " ";
            }
            currentPlayer = getNext(currentPlayer);
        }

        return bestPlayerAndTeam;
    }
    //Display the name, team name, and position for the player who was the most aggressive (had the
    //most penalty minutes).
    //Note: If more than one player had the greatest number of penalty minutes, display all the players and their
    //teams.
    public String mostAgressive(){
        String mostAggressive = " ";
        PlayerRecord currentPlayer = getFirst();
        int highest = 0;
        //search for best player or players with most points
        for(int i = 0; i<stats.size();i++){
            if(currentPlayer.getPenaltyMinutes() > highest){
                mostAggressive = currentPlayer.getName() + " " + currentPlayer.getTeamName() + " " + currentPlayer.getPosition();
                highest =currentPlayer.getPenaltyMinutes();
            } else if (currentPlayer.getPenaltyMinutes() == highest) {
                mostAggressive = mostAggressive + ", " +currentPlayer.getName() + " " + currentPlayer.getTeamName() + " " + currentPlayer.getPosition();
            }
            currentPlayer = getNext(currentPlayer);
        }

        return mostAggressive;
    }
    //Display the name and team name for the player who was the MVP (scored the most game winning
    //goals).
    //Note: If more than one player had the greatest number of game winning goals, display all the players and
    //their teams.
    public String MVP(){
        String MVP = " ";
        PlayerRecord currentPlayer = getFirst();
        int highest = 0;
        //search for best player or players with most points
        for(int i = 0; i<stats.size();i++){
            if(currentPlayer.getGameWinningGoals() > highest){
                MVP = currentPlayer.getName() + " " + currentPlayer.getTeamName() + " " + currentPlayer.getPosition();
                highest =currentPlayer.getGameWinningGoals();
            } else if (currentPlayer.getGameWinningGoals() == highest) {
                MVP = MVP + ", " +currentPlayer.getName() + " " + currentPlayer.getTeamName() + " " + currentPlayer.getPosition();
            }
            currentPlayer = getNext(currentPlayer);
        }

        return MVP;
    }
    //Display the name and team name for the most promising player (had the most shots on goal). Note:
    //If more than one player had the greatest number of shots on goal, display all the players and their teams.
    public String mostPromsing(){
        String mostPromising = " ";
        PlayerRecord currentPlayer = getFirst();
        int highest = 0;
        //search for best player or players with most points
        for(int i = 0; i<stats.size();i++){
            if(currentPlayer.getShotsOnGoal() > highest){
                mostPromising = currentPlayer.getName() + " " + currentPlayer.getTeamName() + " " + currentPlayer.getPosition();
                highest =currentPlayer.getShotsOnGoal();
            } else if (currentPlayer.getShotsOnGoal() == highest) {
                mostPromising = mostPromising + ", " +currentPlayer.getName() + " " + currentPlayer.getTeamName() + " " + currentPlayer.getPosition();
            }
            currentPlayer = getNext(currentPlayer);
        }

        return mostPromising;
    }
    //Display the team name for the team that had the most penalty minutes (sum of all penalty minutes
    //for all players on a team).
    //Note: If more than one team had the greatest number of penalty minutes, display all the teams
    public String mostAggressiveTeam(){
        String aggressiveTeam = " ";
        PlayerRecord currentPlayer = getFirst();
        int highest = 0;

        List<String> teams = getTeams();
        String currentTeam = teams.first();
        //the array contains all unique team names and will calculate team by team's penalty minutes
        for(int i = 0; i<teams.size();i++){
            int teamHighest = 0;
            currentPlayer = getFirst();
            //get x team's penalty minutes
            for (int j = 0; j < stats.size(); j++) {
                if(currentPlayer.getTeamName().equals(currentTeam)){
                    teamHighest += currentPlayer.getPenaltyMinutes();
                }
               currentPlayer =  getNext(currentPlayer);
            }
        //after getting the full penalty points we can now check who has the highest penalty points out of all the teams
            if(teamHighest > highest){
                aggressiveTeam = currentTeam;
                highest = teamHighest;
            }else if(teamHighest == highest){
                aggressiveTeam = aggressiveTeam + ", " + currentTeam;
            }
            currentTeam = teams.next();
        }

        return aggressiveTeam;
    }

    //function gets all unique team names in the list and returns a String list of all team names
    public List<String> getTeams(){
        List<String> teams = new List<>();
        PlayerRecord currentPlayer = stats.first();
        for (int i = 0; i < stats.size(); i++) {
            if(!teams.contains(currentPlayer.getTeamName())){
                teams.add(currentPlayer.getTeamName());
            }
            currentPlayer = getNext(currentPlayer);
        }

        return teams;
    }


    //Display the team name for the team that had the most game winning goals (sum of all game winning
    //goals for all players on a team).
    // Note: If more than one team had the greatest number of game winning goals, display all the teams.
    public String teamMVP(){
        String MVPTeam = " ";
        PlayerRecord currentPlayer = getFirst();
        int highest = 0;

        List<String> teams = getTeams();
        String currentTeam = teams.first();
        //the array contains all unique team names and will calculate team by team's penalty minutes
        for(int i = 0; i<teams.size();i++){
            int teamHighest = 0;
            currentPlayer = getFirst();
            //get x team's penalty minutes
            for (int j = 0; j < stats.size(); j++) {
                if(currentPlayer.getTeamName().equals(currentTeam)){
                    teamHighest += currentPlayer.getGameWinningGoals();
                }
                currentPlayer =  getNext(currentPlayer);
            }
            //after getting the full penalty points we can now check who has the highest penalty points out of all the teams
            if(teamHighest > highest){
                MVPTeam = currentTeam;
                highest = teamHighest;
            }else if(teamHighest == highest){
                MVPTeam = MVPTeam + ", " + currentTeam;
            }
            currentTeam = teams.next();
        }

        return MVPTeam;
    }


}
