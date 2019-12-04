package v5.boardgames.game;

import v5.boardgames.player.Player;

/**
 * State of the game, fully described.
 */
public class LimitedGameState extends GameState {
    int[] nbPieces;

    public LimitedGameState(final Board aBoard, final int CurrentPlayer, final IGame aGame, int n) {
        super(aBoard, CurrentPlayer, aGame);
        nbPieces = new int[n];
        for(int i=0; i<n; i++){
          nbPieces[i]=n;
        }
    }
    public int[] getNbPieces(){
      return nbPieces;
    }

    public void decreaseOnePiece(int numPlayer){
      nbPieces[numPlayer]--;
    }




}
