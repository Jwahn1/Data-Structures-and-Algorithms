public class demo {
    public static void main(String[] args) {
        int[] test = {1,2};
        SlowPiece a = new SlowPiece("piece", "red", test );
        System.out.println(a);

        //input example:
        //'move 5 5 left 3'→moves the Piece at (5,5) by 3 spaces to the left.
        //we can add a switch menu with options: "move" "create"
    }
}
