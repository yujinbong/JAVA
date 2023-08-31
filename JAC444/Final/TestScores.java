package Final;

import java.util.Scanner;

public class TestScores {
    double[] array;

    public TestScores(double[] array) throws IllegalArgumentException{
        this.array = array;
    }

    public static boolean isTrue(double score){
        if (score > 100 || score <0){
            throw new IllegalArgumentException("The score must be less than 100 and greater than 0");
        }else {
            return true;
        }
    }

    public double totalAverage() {
        double TT =0.0;
        try{
            for (double score : array){
                if (isTrue(score)){
                    TT += score;
                }
            }
            double average = TT/array.length;
            System.out.println("Average score: " + average);
        }catch (IllegalArgumentException e){
            System.out.println("Exception" + e);
        }
        return TT;
    }

    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("How many score do you want to enter?");
            number = input.nextInt();
        }while (number <1);

        double[] array = new double[number];
        for (int count=0; count <=number -1; count++){
            System.out.print("Enter the score" + (count +1)+ " : ");
            array[count] = input.nextDouble();
        }

        TestScores TS = new TestScores(array);
        TS.totalAverage();
    }


}

