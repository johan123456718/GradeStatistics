
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johan C
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] subjects = {"Matematik", "Svenska", "Engelska", "Historia", "Fysik"};
        int[] points = new int[subjects.length];
        char[] grades = new char[points.length];
        points = readPoints(subjects, points);
        grades = convertFromPointsToGrades(grades, points);
        System.out.println(printGrades(grades));
        System.out.println(printStatistics(grades));
    }
    
    private static int[] readPoints(String[] subjects, int[] points){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < subjects.length; i++){
            System.out.println("Hur mycket poäng fick du lägga på " + subjects[i]);
            points[i] = scan.nextInt();
        }
        return points;
    }
    
    private static char[] convertFromPointsToGrades(char[] grades, int[] points){
        for(int i = 0; i < points.length; i++){
            if(points[i] == 100){
                grades[i] = 'A';
            }else if(points[i] == 80){
                grades[i] = 'B';
            }else if(points[i] == 70){
                grades[i] = 'C';
            }else if(points[i] == 60){
                grades[i] = 'D';
            }else if(points[i] == 50){
                grades[i] = 'E';
            }else{
                grades[i] = 'F';
            }
        }
        return grades;
    }
    
    private static String printGrades(char[] grades){
        StringBuilder sb = new StringBuilder();
        sb.append("Grades\n");
        sb.append("[");
        for(int i = 0; i < grades.length; i++){
            sb.append(grades[i]).append(", "); 
        }
        sb.append("]");
        return sb.toString();
    }
    
    private static String printStatistics(char[] grades){
        StringBuilder sb = new StringBuilder();
        sb.append("Statstics\n");
        HashMap<Character, Integer> map = new HashMap<>();
        char[] tmp = {'A', 'B', 'C', 'D', 'E', 'F'};
        
        for(int i = 0; i < tmp.length; i++){
            map.put(tmp[i], 0);
        }
        
        for(int i = 0; i < grades.length; i++){
            if(grades[i] == 'A'){
                map.put('A', map.get('A') + 1);
                
            }else if(grades[i] == 'B'){
                map.put('B', map.get('B') + 1);
                
            }else if(grades[i] == 'C'){
                map.put('C', map.get('C') + 1);
               
            }else if(grades[i] == 'D'){
                map.put('D', map.get('D') + 1);
                
            }else if(grades[i] == 'E'){
                map.put('E', map.get('E') + 1);
                
            }else{
                map.put('F', map.get('F') + 1);
            }
        }
        sb.append("A: ").append(map.get('A'));
        sb.append("\nB: ").append(map.get('B'));
        sb.append("\nC: ").append(map.get('C'));
        sb.append("\nD: ").append(map.get('D'));
        sb.append("\nE: ").append(map.get('E'));
        sb.append("\nF: ").append(map.get('F'));
        return sb.toString();
    }
    
}
