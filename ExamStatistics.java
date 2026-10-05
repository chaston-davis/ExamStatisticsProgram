import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class ExamStatistics {

	private static Scanner inputFileScanner;

	public static void main(String[] args){ // Main
		String inFile = "exam_scores.txt";
        int[] scores = new int[100];
        int count = 0;

        try {
            inputFileScanner = new Scanner(new FileReader(inFile));

            while (inputFileScanner.hasNextInt() && count < scores.length) {
                scores[count] = inputFileScanner.nextInt();
                count++;
            }

            inputFileScanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        // Print the stored scores
        for (int i = 1; i < count; i++) {
            System.out.println(scores[i]);
        }
    welcomeMessage(findMax(scores), findMin(scores), findAverage(scores), scores, count);
    }

    public static int findMax(int [] scores){ // Maximum Score
    int max = 0;
    for (int i = 0; i < scores.length; i++){
    if (scores[i] > max){
        max = scores[i];
    }
    }
    return max;
    }

    public static int findMin(int [] scores){ // Minimum Score
    int min = 100;
    for (int i = 1; i < scores.length; i++){
    if (scores[i] < min && scores[i] != 0){
        min = scores[i];
    }
    }
    return min;
    }

    public static double findAverage(int [] scores){ // Average Score
    int sum = 0;
    int count = 0;
    for (int i = 1; i < scores.length; i++){
    if (scores[i] != 0){
        sum += scores[i];
        count++;
    }
    }
    return sum / count;
    }

    public static int[] numberofScoresByGrade(int [] scores){ // Scores by Grade
        int[] gradeCount = new int[5];
        for (int i = 1; i < scores.length; i++){
            if (scores[i] >= 90){
                gradeCount[0]++;
            }
            else if (scores[i] >= 80){
                gradeCount[1]++;
            }
            else if (scores[i] >= 70){
                gradeCount[2]++;
            }
            else if (scores[i] >= 60){
                gradeCount[3]++;
            }
            else if (scores[i] < 60 && scores[i] != 0){
                gradeCount[4]++;
            }
        }
        System.out.println("A: " + gradeCount[0]);
        System.out.println("B: " + gradeCount[1]);
        System.out.println("C: " + gradeCount[2]);
        System.out.println("D: " + gradeCount[3]);
        System.out.println("F: " + gradeCount[4]);
        return gradeCount;
    }
    
    public static void welcomeMessage(int max, int min, double average, int[] scores, int count){ // Welcome Message
        System.out.println("***Welcome to the Exam Statistics Program!!***");
        System.out.println("Your file is called: " + "exam_scores.txt");
        System.out.println("Minimum Score: " + min);
        System.out.println("Maximum Score: " + max);
        System.out.println("Average Score: " + average);
        System.out.println("Number of Scores by letter grade:");
        numberofScoresByGrade(scores);
        System.out.println("There are " + (count - 1) + " scores");
    }

}
