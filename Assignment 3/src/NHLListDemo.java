import java.util.*;
public class NHLListDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NHLStats list = new NHLStats();

        //create list
        for(int i = 0 ; i < 5;i++) {
            PlayerRecord player = new PlayerRecord(in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next());
            list.add(player);
        }

        PlayerRecord temp = list.getFirst();

        System.out.println(list.mostPoint());
        System.out.println(list.mostAgressive());
        System.out.println(list.MVP());
        System.out.println(list.mostPromsing());
        System.out.println(list.mostAggressiveTeam());
        System.out.println(list.teamMVP());
        //Finally, create a demo program. Call it NHLListDemo.java. It will be similar to ExpenseListDemo.java or
        //StudentListDemo.java in your lab. Your program should accept input from a user (specifying the name of
        //an input file) and read a file formatted like the one described (see also: nhlstats.txt). Your program should
        //create an NHLStats Object, and demonstrate all the methods that you have developed. You will print your
        //outputs in the following format to a file called nhlstatsoutput.txt

        //Enter the filename to read from: nhlstats.txt
        //NHL Results Summary
        //Players with highest points and their teams:
        //*YOUR OUTPUT(S)*
        //Most aggressive players, their teams and their positions:
        //*YOUR OUTPUT(S)*
        //Most valuable players and their teams:
        //*YOUR OUTPUT(S)*
        //Most promising players and their teams:
        //*YOUR OUTPUT(S)*
        //Teams that had the most number of penalty minutes:
        //*YOUR OUTPUT(S)*
        //Assignment 3CSCI 2110 2
        //Teams that had the most number of game winning goals:
        //*YOUR OUTPUT(S)*
        //Note: When you read data from the file, each line is read as a String. Use a StringTokenizer to parse the line’s
        //components. Also take note that the input file has rows in which the items are delimited by tabs, not spaces.
        //Try the following when setting your delimiter:
        //token = new StringTokenizer(line, "\t");
    }
}



 */