public class Main
{
  public static void main(String[] args)
  {
    Board ticTacToeBoard = new Board(new char[] {'X','X','O','O','X','X','X','O','O'});
    MiniMax miniMax = new MiniMax();

    System.out.println(miniMax.miniMax(ticTacToeBoard, true));

    System.out.println(ticTacToeBoard.toString());
  }
}
