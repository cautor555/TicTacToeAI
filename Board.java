import java.util.*;

public class Board
{
  protected char[] boardState;

  protected Board()
  {
    boardState = new char[9];
    Arrays.fill(boardState,'-');
  }

  protected Board(char[] c)
  {
    boardState = c.clone();
  }

  protected boolean compare(Board state)
  {
    for(int i = 0; i<boardState.length; i++)
    {
      if(boardState[i] != state.getSpot(i))
        return false;
    }
    return true;
  }

  protected char getSpot(int i)
  {
    return boardState[i];
  }

  protected void makeMove(char c, int i)
  {
    boardState[i] = c;
  }

  protected Board returnMove(char c, int i)
  {
    Board makeBoardState = new Board(boardState.clone());
    makeBoardState.makeMove(c, i);
    return makeBoardState;
  }

  public String toString()
  {
    String S = "";
    for(int i = 0; i<boardState.length; i++)
      S += boardState[i];
    return S;
  }

  protected void printBoard()
  {
    for(int i = 0; i<boardState.length; i++)
    {
      if(i%3 == 0)
        System.out.print("\n");
      System.out.print(boardState[i]);
    }
  }

  protected boolean contains(char c)
  {
    for(int i = 0; i<boardState.length; i++)
    {
      if(boardState[i] == c)
        return true;
    }
    return false;
  }

}
