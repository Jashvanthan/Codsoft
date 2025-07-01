import java.lang.*;
import java.util.*;
public class StudentGrade {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF SUBJECT:");
        int n=sc.nextInt();
        int[] a=new int[n];
        float average;
        for(int i=0;i<a.length;i++)
        {
            int N=i+1;
            System.out.println("ENTER THE SUBJECT"+N+" mark out of 100:");
            a[i]=sc.nextInt();
            if(a[i]>=0&&a[i]<=100)
            {
                continue;
            }
            else
            {

                System.out.println("your mark is  incorrect ;the exams are conduct by 100 in each subject ");
                System.out.println("So Reenter the subject"+N+" mark out of 100:");
                a[i]=sc.nextInt();
            }

        }
        System.out.println(".....Student Result.....");
        for(int i=0;i<a.length;i++)
        {
            int N = i + 1;
            System.out.println("  mark of subject" + N + " is:" + a[i]);
        }
        int total_Exam_marks=n*100;
        System.out.println("TOTAL MARK :"+Arrays.stream(a).sum()+" out of "+total_Exam_marks);
        average= Arrays.stream(a).sum()/n;
        System.out.println(String.format("Average of the mark is:%.2f",average));
        System.out.println("student exam percentage:"+average+"% out of 100%");
        if(average>=90)
        {
            System.out.println("student Have Get First Grade ");
            System.out.println("student grade is:Grade 'o'");
        }
       else if(average<90&&average>=80)
        {
            System.out.println("student Have Get second level  Grade ");
            System.out.println("student grade is:Grade 'A++'");
        }
       else if (average<80&&average>=65)
       {
           System.out.println("student Have Get third level  Grade ");
           System.out.println("student grade is:Grade 'A'");
        }
       else if(average<65&&average>=55)
        {
            System.out.println("student grade is:Grade 'B++'");
        } else if(average<55&&average>=45)
        {
            System.out.println("student grade is:Grade 'B'");
        }
       else
        {
            System.out.println("student are fail in exam");
        }
    }

}
