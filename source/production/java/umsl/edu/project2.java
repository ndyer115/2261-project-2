package umsl.edu;
import java.util.Scanner;
public class project2 {
    public static void main (String[] args)
    {
        char begintest;
        boolean startgame = false;
        System.out.println("would you like to play connect 4: Y/N:");
        Scanner begin = new Scanner(System.in);

        while (!startgame) {
            String testString = begin.nextLine();
            begintest = testString.charAt(0);
            if (begintest == 'y' || begintest == 'Y') {
                System.out.println("player 1 is red, player 2 is yellow. Have fun!");
                startgame = true;
            }
            else if (begintest == 'n' || begintest == 'N') {
                System.out.print("closing program");
                return;
            } else {
                System.out.print("invalid input, try again.");
            }
        }
        String[][] f = makegrid();
        boolean loop = true;
        int count = 0;
        printgrid(f);
        while(loop)
        {
            if (count % 2 == 0) redmove(f);
            else yellowmove(f);
            count++;
            printgrid(f);
            if (checkwin(f) != null)
            {
                if (checkwin(f) == "R")
                    System.out.println("Player 1 wins!");
                else if (checkwin(f)== "Y")
                    System.out.println("Player 2 wins!");
                loop = false;
            }
        }
    }
    public static String[][] makegrid()
    {
        String[][] f = new String[7][15];

        for (int i =0;i<f.length;i++)
        {

            for (int j =0;j<f[i].length;j++)
            {

                if (j% 2 == 0) f[i][j] ="|";
                else f[i][j] = " ";
                if (i==6) f[i][j]= "-";
            }

        }
        return f;
    }


    public static void printgrid(String[][] f)
    {
        for (int i =0;i<f.length;i++)
        {
            for (int j=0;j<f[i].length;j++)
            {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }


    public static void redmove(String[][] f) {

        boolean check = false;

        System.out.println("Player 1, drop a red chip in column (0–6): ");

        while(!check) {
            try {
                Scanner scan = new Scanner(System.in);
                int input = scan.nextInt();
                if (input < 0 || input > 6) {
                    System.out.println("Not a valid input, try again:");
                } else {
                    int c = 2 * input + 1;
                    for (int i = 5; i >= 0; i--) {
                        if (f[i][c] == " ") {
                            f[i][c] = "R";
                            check = true;
                            break;

                        }

                    }

                }
            }catch(java.util.InputMismatchException exception){
                System.out.println("Not a valid input, try again:");
            }
        }


    }
    public static void yellowmove(String[][] f) {
        boolean check = false;
        System.out.println("Player 2, drop a yellow chip in column (0–6): ");
        while (!check) {
            try {
                Scanner scan = new Scanner(System.in);
                int input = scan.nextInt();
                if (input < 0 || input > 6) {
                    System.out.println("Not a valid input, try again:");
                } else {
                    int c = 2 * input + 1;
                    for (int i = 5; i >= 0; i--) {
                        if (f[i][c] == " ") {
                            f[i][c] = "Y";
                            check = true;
                            break;
                        }
                    }

                }
            }catch(java.util.InputMismatchException exception){
                System.out.println("Not a valid input, try again:");
            }
        }
    }

    public static String checkwin(String[][] f)
    {

        for (int i =0;i<6;i++)
        {

            for (int j=0;j<7;j+=2)
            {
                if ((f[i][j+1] != " ")
                        && (f[i][j+3] != " ")
                        && (f[i][j+5] != " ")
                        && (f[i][j+7] != " ")
                        && ((f[i][j+1] == f[i][j+3])
                        && (f[i][j+3] == f[i][j+5])
                        && (f[i][j+5] == f[i][j+7])))

                    return f[i][j+1];
            }
        }

        for (int i=1;i<15;i+=2)
        {
            for (int j =0;j<3;j++)
            {
                if((f[j][i] != " ")
                        && (f[j+1][i] != " ")
                        && (f[j+2][i] != " ")
                        && (f[j+3][i] != " ")
                        && ((f[j][i] == f[j+1][i])
                        && (f[j+1][i] == f[j+2][i])
                        && (f[j+2][i] == f[j+3][i])))
                    return f[j][i];
            }
        }
        for (int i=0;i<3;i++)
        {
            for (int j=1;j<9;j+=2)
            {
                if((f[i][j] != " ")
                        && (f[i+1][j+2] != " ")
                        && (f[i+2][j+4] != " ")
                        && (f[i+3][j+6] != " ")
                        && ((f[i][j] == f[i+1][j+2])
                        && (f[i+1][j+2] == f[i+2][j+4])
                        && (f[i+2][j+4] == f[i+3][j+6])))
                    return f[i][j];
            }
        }

        for (int i=0;i<3;i++)
        {
            for (int j=7;j<15;j+=2)
            {
                if((f[i][j] != " ")
                        && (f[i+1][j-2] != " ")
                        && (f[i+2][j-4] != " ")
                        && (f[i+3][j-6] != " ")
                        && ((f[i][j] == f[i+1][j-2])
                        && (f[i+1][j-2] == f[i+2][j-4])
                        && (f[i+2][j-4] == f[i+3][j-6])))
                    return f[i][j];
            }
        }
        return null;
    }

}
