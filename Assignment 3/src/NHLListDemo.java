import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class NHLListDemo {
    public static void main(String[] args) {
        Scanner in = null;
        Scanner file = new Scanner(System.in);

        System.out.println("what file would you like to read");
        File nhlstats = new File(file.next());
        //in case the file doesnt exist
        try {
            in = new Scanner(nhlstats);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        NHLStats list = new NHLStats();

        //create list based on provided file
        while(in.hasNext()){
            PlayerRecord player = new PlayerRecord(in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next());
            list.add(player);
        }

        PlayerRecord temp = list.getFirst();

        System.out.println(
                "NHL Results Summary: \n"+
                "player/s with highest point/s and their team/s:\n"+ list.mostPoint()+ "\n"+
                "Most aggressive players, their teams and their positions:\n"+ list.mostAgressive()+"\n"+
                "Most valuable players and their teams:\n"+ list.MVP()+"\n"+
                "Most promising players and their teams\n"+ list.mostPromsing()+"\n"+
                "Teams that had the most number of penalty minutes:\n"+ list.mostAggressiveTeam()+"\n"+
                "Teams that had the most number of game winning goals:\n"+ list.teamMVP()+"\n"
        );

        //output the last printout into a seperate file
        File nhlOutput = new File("Docs/nhlstatsoutput.txt");
        try {
            FileWriter writer = new FileWriter("Docs/nhlstatsoutput.txt");
            writer.write("NHL Results Summary: \n"+
                    "player/s with highest point/s and their team/s:\n"+ list.mostPoint()+ "\n"+
                    "Most aggressive players, their teams and their positions:\n"+ list.mostAgressive()+"\n"+
                    "Most valuable players and their teams:\n"+ list.MVP()+"\n"+
                    "Most promising players and their teams\n"+ list.mostPromsing()+"\n"+
                    "Teams that had the most number of penalty minutes:\n"+ list.mostAggressiveTeam()+"\n"+
                    "Teams that had the most number of game winning goals:\n"+ list.teamMVP()+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}



