import java.util.*;

public class Board
{
  private char[] boardState;

  public Board()
  {
    boardState = new char[9];
    Arrays.fill(boardState,'-');
  }

  public String toString()
  {
    String S = "";
    for(int i = 0; i<boardState.length; i++)
      S += boardState[i];
    return S;
  }

}
