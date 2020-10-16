public class RPSPlayer {

  private int score;
  private String name;

  public RPSPlayer(int score, String name) {
    this.score = score;
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void incrementScore(){
    score++;
  }
}
