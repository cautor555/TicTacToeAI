public class MiniMax
{
  private int value;

  public int miniMax(Board state, boolean MaxPlayer)
  {

    if(termTest(state))
        return value;

    else
      return -1000;

  }

  public boolean termTest(Board state)
  {
    char centerSquare = state.getSpot(4);

    if(centerSquare == 'X')
      value = 1;
    else if(centerSquare == 'O')
      value = -1;
    else
      return false;

    if(centerSquare == state.getSpot(0) && centerSquare == state.getSpot(8))
      return true;
    else if(centerSquare == state.getSpot(6) && centerSquare == state.getSpot(2))
      return true;
    else if(centerSquare == state.getSpot(1) && centerSquare == state.getSpot(7))
      return true;
    else if(centerSquare == state.getSpot(3) && centerSquare == state.getSpot(5))
      return true;
    else if(!state.contains('-'))
    {
      value = 0;
      return true;
    }
    return false;
  }

}
