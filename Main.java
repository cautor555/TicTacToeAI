import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    MiniMax miniMax;
    char playerChar;
    char computerChar;
    int turns;


    Scanner sc = new Scanner(System.in);
    System.out.println("Chose 'X' or 'O' ");

    if(Character.toUpperCase(sc.next().charAt(0)) == 'O')
    {
      turns = 0;
      miniMax = new MiniMax();
      playerChar = 'O';
      computerChar = 'X';
    }
    else
    {
      turns = 1;
      miniMax = new MiniMax('X', 'O');
      playerChar = 'X';
      computerChar = 'O';
    }

    Board ticTacToeBoard = new Board();

    while(!miniMax.termTest(ticTacToeBoard))
    {
      ticTacToeBoard.printBoard();
      System.out.print("\n");

      if(turns%2 == 0)
      {
        int maxValue = -1;
        int maxValuePosition = 0;
        int tempValue;

        for(int i = 0; i<9; i++)
        {
          if(ticTacToeBoard.getSpot(i) == '-')
          {
            tempValue = miniMax.miniMax(ticTacToeBoard.returnMove(computerChar,i), false);
            if(tempValue>maxValue)
            {
              maxValue = tempValue;
              maxValuePosition = i;
            }
          }
        }
        ticTacToeBoard.makeMove(computerChar,maxValuePosition);
      }

      else
      {

        System.out.println();
        int playerInput = -1;
        while(playerInput < 1 || playerInput > 9)
        {
          System.out.println("Chose move (position 1-9) ");
          playerInput = sc.nextInt();
        }

        ticTacToeBoard.makeMove(playerChar, playerInput-1);
      }
      turns++;
    }

    ticTacToeBoard.printBoard();

    miniMax.termTest(ticTacToeBoard);
    if(miniMax.getValue() == playerChar)
      System.out.println("\n\nYou Win!");
    else if(miniMax.getValue() == computerChar)
      System.out.println("\n\nComputer Wins");
    else
      System.out.println("\n\nTie");

  }
}
