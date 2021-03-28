import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Board ticTacToeBoard = new Board();
    MiniMax miniMax = new MiniMax();

    Scanner sc = new Scanner(System.in);

    int turns = 0;
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
            tempValue = miniMax.miniMax(ticTacToeBoard.returnMove('X',i), false);
            if(tempValue>maxValue)
            {
              maxValue = tempValue;
              maxValuePosition = i;
            }
          }
        }
        ticTacToeBoard.makeMove('X',maxValuePosition);
      }

      else
      {
        System.out.println("Chose move (position 1-9) ");
        ticTacToeBoard.makeMove('O',sc.nextInt()-1);
      }
      turns++;
    }

    ticTacToeBoard.printBoard();
  }
}
