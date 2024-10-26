public class Excercise7 {
    public static void main(String[] args) {
        String reverse = reverseString("hello");
        System.out.print(reverse);
    }
    //takes a string str and returns the string in reverse order
    public static String reverseString(String str){

        if(str.length()> 0){
            String temp = str.substring(str.length()-1);
            str = str.substring(0,str.length()-1);
            str = temp + reverseString(str);
        }

        return str;
    }
}
