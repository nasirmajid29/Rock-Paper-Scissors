public enum GameObj {

  R, P, S;

  public boolean beats(GameObj other){

    switch (this){
      case R:
        return other == S;

      case P:
        return other == R;

        case S:
        return other == P;

     }
     return false;
  }

  @Override
  public String toString() {
    if(this.equals(R)){
      return "Rock";
    }
    if(this.equals(P)){
      return "Paper";
    }
    if(this.equals(S)){
      return "Scissors";
    }
    return "not a valid game object!";
  }
}
