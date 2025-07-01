import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score=0;
        System.out.println("                  rules of gram \n1.the gram have  been three rounds and each round have give three chance ");
        System.out.println("2.first you have enter the  number in between 1 to 100");
        System.out.println(" if the input  match to generated number out of three chance you selected to next round and,");
        System.out.print(" if you win the rounds we provide score at end of the gram .the score based on how many chance you have taken \n");
        System.out.println("3.if your number is not match to the generated number .you have eliminated to the gram ");
        System.out.println("4.if you complete the all rounds .you are win the gram  \n.... let's play the gram.... ");
        for (int i = 1; i <= 3;i++) {
            System.out.println(i + "th chance:\nEnter the number :");
            int n = sc.nextInt();
            if(n>=1&&n<=100)
            {
            int min = 1;
            int l=generateRandomNum(n,min);
            if (l> n)
            {
                System.out.print("generated number Too greater so,");
            }
            else if (l== n) {
                System.out.println("equal to generated number");
                System.out.println("you go to next level");
                if(i==1) {
                    score += 25;
                }
                else {
                    score+=20;
                }
                secondRound(score);
                break;
            } else {
                System.out.print("generated number is Too low so,");
            }
                if(i==1||i==2)
                {
                    System.out.println(" try again");
                }
                else if(i==3)
                {
                    System.out.println("\n.....sorry you are eliminated.......");
                    System.out.println("your score is:"+score+" out of 100");
                }

            }
            else
            {
                System.out.println("sorry please read the rules of the gram ");
                break;
            }
        }
    }

    public static int generateRandomNum(int n, int min) {
        int random = min+ (int) (Math.random() * (n - min) + 1);
        System.out.println("generated number:"+random);
        return random;
    }

    public static void secondRound(int score)
    {
        Scanner sc=new Scanner(System.in);
      System.out.println("second round");
        for(int i=1;i<=3;i++)
        {
            System.out.println(i+"th chance");
            System.out.println("Enter the number:");
            int p= sc.nextInt();
            if(p>=1&&p<=100)
            {
                int mins = 12;
                int l = generateRandomNum(p, mins);
                if (l > p) {
                    System.out.println("generated number is Too greater so,");
                } else if (l == p) {
                    System.out.println("equal to generated number so go finial round");
                    if (i == 1) {
                        score += 30;
                    } else {
                        score += 27;
                    }
                    finalRound(score);
                    break;
                } else {
                    System.out.println("generated number is Too low so, ");
                }
                if (i == 1 || i == 2) {
                    System.out.println(" try again");
                } else if (i == 3) {
                    System.out.println("\n.....sorry you are eliminated.......");
                    System.out.println("your score is:" + score + " out of 100");
                }
            }
           else
         {
            System.out.println("sorry please read rules of the gram ");
            break;
         }
    }
    }
    public static void finalRound(int score)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Final round");
        for(int i=1;i<=3;i++)
        {
            System.out.println(i+"th chance");
            System.out.println("Enter the number:");
            int p= sc.nextInt();
           if(p>0&&p<=100) {
               int mins = 22;
               int l = generateRandomNum(p, mins);
               if (l > p) {
                   System.out.println("Too greater");
               } else if (l == p) {
                   System.out.println("equal to generated number so go finial round");
                   System.out.println("Congratulations to win the  match");
                   if (i == 1) {
                       score += 45;
                   } else if (i == 2) {
                       score += 40;
                   } else {
                       score += 36;
                   }
                   System.out.println("your score is:" + score + " out of 100");
                   break;
               } else {
                   System.out.print("Too low");
               }
               if (i == 1 || i == 2) {
                   System.out.println(" try again");
               } else if (i == 3) {
                   System.out.println("\n.....sorry you are eliminated.......");
               }
           }
            else
            {
                System.out.println("sorry please read rules of the gram ");
                break;
            }
        }
    }
}




