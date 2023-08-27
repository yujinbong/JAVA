import java.util.Scanner;
public class Scores {
 
public static void main(String[] args) {
 
System.out.println("Enter the number of students: ");
 
Scanner studets = new Scanner(System.in);
 
int[] scores = new int[studets.nextInt()
];
 
char[] grades = new char[scores.length];
 
System.out.println("Enter " + scores.length + "scores: ");
 
for (int i=0; i < scores.length; i++)
{
 
scores[i] = studets.nextInt();
 
}
 
getGrades(scores, grades);
 
for (int i=0; i< scores.length; i++)
{
 
System.out.println("Student " + i + "score is "+ scores[i] + "and grade is "+ grades[i]
);
 
}
 
}
 
public static int max(int[] scores)
{
 
int max = scores[0];
 
for (int i=1; i<scores.length; i++)
{
 
if (scores[i]>max)
 
max=scores[i];
 
}
 
return max;
 
}
 
public static void getGrades(int[] scores,char[] grades)
{
 
int best = max(scores);
 
for (int i=0; i< scores.length; i++)
{
 
if (scores[i] >= best - 10)
 
grades[i] ='A';
 
else if(scores[i] >= best -20)
 
grades[i] = 'B';
 
else if(scores[i] >= best -30)
 
grades[i] = 'C';
 
else if(scores[i] >= best - 40)
 
grades[i] = 'D';
 
else grades[i] = 'F';
 
}
 
}
