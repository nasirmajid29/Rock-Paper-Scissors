import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.Scanner;

public class RPSRunner {
  public static void main(String[] args) {

    RPSPlayer p1 = new RPSPlayer(0, "");
    RPSPlayer p2 = new RPSPlayer(0, "");
    RPS game = new RPS(p1, p2, 0);

    System.out.println("Let's play Rock, Paper, Scissors!\n");

    game.initialiser();

    System.out.println("Rock = R, Paper = P, and Scissors = S\n");

    game.play();
    // check if equal, then use beat function. else if
    System.out.println();
    }
}
