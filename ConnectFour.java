import java.util.Scanner;
public class ConnectFour {

    public static void printBoard(char[][] array){
        for (int i = array.length- 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] array){
        for(int k =0; k < array.length; k++){
            for(int l = 0; l < array[k].length; l++){
                array[k][l] = '-';
            }
            System.out.println();
        }
    }

    public static int insertChip(char[][] array, int col, char chipType){
        for (int m = 0; m < array.length; m++){
            if (array[m][col] == '-') {
                array[m][col] = chipType;
                return m;

            }


        }
        return -1;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        int count = 0;

        for(int n = 0; n < array.length; n++){
            if(array[n][col] == chipType){
                count++;
                if(count == 4){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        count = 0;

        for(int p = 0; p < array[0].length; p++){
            if(array[row][p] == chipType){
                count++;

                if(count == 4){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int boardHeight;
        int boardLength;
        int colChoice;
        Scanner scnr = new Scanner(System.in);
        char chip1 = 'x';
        char chip2 = 'o';
        boolean check1;
        boolean check2;



        System.out.print("What would you like the height of the board to be? ");
        boardHeight = scnr.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        boardLength = scnr.nextInt();
        char[][] gameBoard = new char[boardHeight][boardLength];
        initializeBoard(gameBoard);
        printBoard(gameBoard);
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        while(true) {
            System.out.print("Player 1: Which column would you like to choose? ");
            colChoice = scnr.nextInt();
            insertChip(gameBoard, colChoice, chip1);
            printBoard(gameBoard);
            check1 = checkIfWinner(gameBoard, colChoice, 0, 'x');
            if(check1 == true){
                System.out.println("Player 1 won the game!");
                break;
            }
            System.out.print("Player 2: Which column would you like to choose? ");
            colChoice = scnr.nextInt();
            insertChip(gameBoard, colChoice, chip2);
            printBoard(gameBoard);
            check2 = checkIfWinner(gameBoard, colChoice, 0, 'o');
            if(check2 == true){
                System.out.println("Player 2 won the game!");
                break;
            }



        }
    }
}
