/**
* Class name: Board
* Object to represent tic tac toe board
*
* @author  Christian Autor
* @version 1.0
* @since   3/30/2021
*/

import java.util.*;

public class Board
{
  protected char[] boardState;

/**
  * Board constructor
  *
  * @param  none
  * @return none
  */
  protected Board()
  {
    boardState = new char[9];
    Arrays.fill(boardState,'-');
  }

/**
  * Board constructor
  *
  * @param  char c[]
  * @return none
  */
  protected Board(char[] c)
  {
    boardState = c.clone();
  }

/**
  * getSpot method
  *
  * @param  int i
  * @return char
  */
  protected char getSpot(int i)
  {
    if(i>=0 && i<9)
      return boardState[i];
    return '-';
  }

/**
  * makeMove method
  *
  * @param  char c, int i
  * @return none
  */
  protected void makeMove(char c, int i)
  {
    boardState[i] = c;
  }

/**
  * returnMove method
  *
  * @param  char c, int i
  * @return Board
  */
  protected Board returnMove(char c, int i)
  {
    Board makeBoardState = new Board(boardState.clone());
    makeBoardState.makeMove(c, i);
    return makeBoardState;
  }

/**
  * toString method
  *
  * @param  none
  * @return String
  */
  public String toString()
  {
    String S = "";
    for(int i = 0; i<boardState.length; i++)
      S += boardState[i];
    return S;
  }

/**
  * printBoard method
  *
  * @param  none
  * @return none
  */
  protected void printBoard()
  {
    for(int i = 0; i<boardState.length; i++)
    {
      if(i%3 == 0)
        System.out.print("\n");
      System.out.print(boardState[i]);
    }
  }

/**
  * contains method
  *
  * @param  char c
  * @return boolean
  */
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
