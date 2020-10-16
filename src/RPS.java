import java.util.Scanner;

public class RPS {

  public static void main(String[] args) {
    RPSPlayer p1 = new RPSPlayer(0, "");
    RPSPlayer p2 = new RPSPlayer(0, "");
    RPS game = new RPS(p1, p2, 0);


    Scanner scanner = new Scanner(System.in);

    System.out.println("Let's play Rock, Paper, Scissors!\n");

    game.initialiser();

    System.out.println("Rock = R, Paper = P, and Scissors = S\n");

    game.play();
    // chec if equal, then use beat function. else if
    System.out.println();
  }

  RPSPlayer p1;
  RPSPlayer p2;
  int gameNo;
  int gamesPlayed = 0;

  public RPS(RPSPlayer p1, RPSPlayer p2, int gameNo) {
    this.p1 = p1;
    this.p2 = p2;
    this.gameNo = gameNo;
  }

  private static boolean isValidEnum(String name) {
    if (name == null) {
      return false;
    }
    try {
      GameObj.valueOf(name);
      return true;
    } catch (IllegalArgumentException ex) {
      return false;
    }
  }

  public static void clearScreen() {
    int limit = 50;
    for (int i = 0; i < limit; i++) {
      System.out.println();
    }
  }

  public void initialiser() {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter a name Player 1:");
    p1.setName(scanner.next());

    System.out.println("Please enter a name Player 2:");
    p2.setName(scanner.next());

    do {
      System.out.println("Please enter a number of games to play (3, 5 or 7):");

      while (!scanner.hasNextInt()) {
        System.out.println("That's not a number! Try again");
        System.out.println("3, 5 or 7");
        scanner.next();
      }
      gameNo = Integer.parseInt(scanner.next());
    } while (gameNo != 3 && gameNo != 5 && gameNo != 7);
  }

  public GameObj moveScanner(Scanner scanner) {
    while (true) {
      String move = scanner.next();
      if (isValidEnum(move)) {
        return GameObj.valueOf(move.toUpperCase());

      } else {
        System.out.println("Invalid move, Please try again");
      }
    }
  }

  public void printScore() {
    System.out.println(p1.getName() + " - " + p1.getScore());
    System.out.println(p2.getName() + " - " + p2.getScore());
    System.out.println("Games Played - " + gamesPlayed);
    System.out.println();
  }

  public void playAgain(Scanner scanner){
    
    String response;
    do{
      System.out.println("Play again? (Y/N)");
      response = scanner.next();
    } while (!response.equals("Y") && !response.equals("N"));

    if(response.equals("Y")){
      String[] args = new String[0];
      main(args);
    }else{
      return;
    }
  }
  
  public void play() {

    GameObj p1Move;
    GameObj p2Move;
    Scanner scanner = new Scanner(System.in);
    int movesToWin = (gameNo + 1) / 2;

    while (p1.getScore() < movesToWin && p2.getScore() < movesToWin) {

      System.out.println(p1.getName() + " enter a move:");
      p1Move = moveScanner(scanner);

      clearScreen();

      System.out.println(p2.getName() + " enter a move:");
      p2Move = moveScanner(scanner);

      if (p1Move == p2Move) {
        System.out.println("You both played " + p1Move.toString());
        System.out.println("It's a tie");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println();
      }

      if (p1Move.beats(p2Move)) {
        gamesPlayed++;
        p1.incrementScore();
        clearScreen();
        System.out.println(p1Move + " beats " + p2Move);
        System.out.println(p1.getName() + " won!");
        printScore();
      }
      if (p2Move.beats(p1Move)) {
        gamesPlayed++;
        p2.incrementScore();
        clearScreen();
        System.out.println(p2Move + " beats " + p1Move);
        System.out.println(p2.getName() + " won!");
        printScore();
      }
    }
    clearScreen();
    RPSPlayer winner;
    if (p1.getScore() > p2.getScore()) {
      winner = p1;
    } else {
      winner = p2;
    }

    printScore();
    System.out.println(winner.getName() + " WINS!!!");
    System.out.println("CONGRATULATIONS");
    
    playAgain(scanner); 

    // to do winning statements
  }
}
