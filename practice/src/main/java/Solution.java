public class Solution {

    public static void main(String[] args) {
        String s = "He is a very very good boy, isn't he?";
        // Write your code here.


        String[] arr = s.split("[^A-Za-z]");
        System.out.println(arr.length);
        for (String p : arr) {
            System.out.println(p);

        }
    }
}

