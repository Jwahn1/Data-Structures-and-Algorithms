public class Excercise5 {
    public static void main(String[] args) {
        writeVertical(12);
    }

    //Takes a single positive integer n as a parameter and prints the digits of that integer vertically, one per line.
    public static void writeVertical(int n){{
        String vertical = Integer.toString(n);
        if(vertical.length()>0){
            System.out.println(vertical.charAt(0));
            if(vertical.length()!=1){
                writeVertical(Integer.parseInt(vertical.substring(1)));
            }

        }

    }

    }

}
