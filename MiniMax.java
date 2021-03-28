public class MiniMax
{
  private final char BLANK_SPOT = '-';
  private final char PLAYER_CHAR;
  private final char COMPUTER_CHAR;
  private char value;

  public MiniMax()
  {
    PLAYER_CHAR = 'O';
    COMPUTER_CHAR = 'X';
  }

  public MiniMax(char p, char c)
  {
    PLAYER_CHAR = p;
    COMPUTER_CHAR = c;
  }

  public int miniMax(Board state, boolean MaxPlayer)
  {

    if(termTest(state))
    {
      if(value == COMPUTER_CHAR)
        return 1;
      if(value == PLAYER_CHAR)
        return -1;

      return 0;
    }
    else if(MaxPlayer)
    {
      int maxEval = Integer.MIN_VALUE;

      for(int i = 0; i<9; i++)
      {
        if(state.getSpot(i) == BLANK_SPOT)
        {
          int eval = miniMax(state.returnMove(COMPUTER_CHAR,i), false);
          if(eval > maxEval)
            maxEval = eval;
        }
      }
      return maxEval;
    }

    else
    {
      int maxEval = Integer.MAX_VALUE;

      for(int i = 0; i<9; i++)
      {
        if(state.getSpot(i) == BLANK_SPOT)
        {
          int eval = miniMax(state.returnMove(PLAYER_CHAR,i), true);
          if(eval < maxEval)
            maxEval = eval;
        }
      }
      return maxEval;
    }

  }

  public boolean termTest(Board state)
  {
    char centerSquare;

    for(int i = 0; i<3; i++)
    {
      if(state.getSpot(i) != BLANK_SPOT && state.getSpot(i) == state.getSpot(i+3) && state.getSpot(i) == state.getSpot(i+6))
      {
        value = state.getSpot(i);
        return true;
      }
    }

    for(int i = 0; i<9; i+=3)
    {
      if(state.getSpot(i) != BLANK_SPOT && state.getSpot(i) == state.getSpot(i+1) && state.getSpot(i) == state.getSpot(i+2))
      {
        value = state.getSpot(i);
        return true;
      }
    }

    centerSquare = state.getSpot(4);

    if(centerSquare != BLANK_SPOT && centerSquare == state.getSpot(0) && centerSquare == state.getSpot(8))
    {
      value = centerSquare;
      return true;
    }
    else if(centerSquare != BLANK_SPOT && centerSquare == state.getSpot(6) && centerSquare == state.getSpot(2))
    {
      value = centerSquare;
      return true;
    }
    else if(!state.contains(BLANK_SPOT))
    {
      value = BLANK_SPOT;
      return true;
    }

    return false;
  }

}
