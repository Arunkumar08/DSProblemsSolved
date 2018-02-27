package arun.problems.ds;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int trips = sc.nextInt();
        sc.nextLine();
        int tripTracker = 0;
        Integer[] output = new Integer[trips];
        while(tripTracker < trips) {
            String input = sc.nextLine();
            String[] numbers = input.split(" ");
            if(numbers.length != 3) {
                System.out.println("Wrong Input!!!");
                return;
            }
            int n,c,m;
            n = Integer.parseInt(numbers[0]);
            c = Integer.parseInt(numbers[1]);
            m = Integer.parseInt(numbers[2]);
            
            int totalChocs = n / c;
            int newChocs = totalChocs;
            int rem = 0;
            
            while(newChocs >= m) {
                rem = (newChocs % m);
                newChocs = newChocs / m;
                totalChocs += newChocs;
                newChocs += rem;
            }
            
            output[tripTracker++] = totalChocs;
        }
        
        for(Integer str : output) {
            System.out.println(str);
        }
    }
}