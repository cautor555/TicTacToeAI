import java.util.*;

public class Board
{
  private char[] boardState;

  public Board()
  {
    boardState = new char[9];
    Arrays.fill(boardState,'-');
  }

  public Board(char[] c)
  {
    boardState = c.clone();
    //Arrays.fill(boardState,'-');
  }

  public boolean compare(Board state)
  {
    for(int i = 0; i<boardState.length; i++)
    {
      if(boardState[i] != state.getSpot(i))
        return false;
    }
    return true;
  }

  public char getSpot(int i)
  {
    return boardState[i];
  }

  public String toString()
  {
    String S = "";
    for(int i = 0; i<boardState.length; i++)
      S += boardState[i];
    return S;
  }

  public boolean contains(char c)
  {
    for(int i = 0; i<boardState.length; i++)
    {
      if(boardState[i] == c)
        return true;
    }
    return false;
  }


}
