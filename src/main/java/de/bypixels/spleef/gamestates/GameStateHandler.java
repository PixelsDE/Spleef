package de.bypixels.spleef.gamestates;

import de.bypixels.spleef.Spleef;

public class GameStateHandler {

    private GameState currentGameState;

    private Spleef plugin;

    private GameState[] gameStates = new GameState[3];


    public GameStateHandler(Spleef plugin) {
        this.plugin = plugin;
        gameStates[0] = new Lobby(plugin);
        gameStates[1] = new Ingame();
        gameStates[2] = new End();

    }


    public void setCurrentGameState(GameStatesEnums gameState) {
        if (currentGameState != null) {
            currentGameState.stop();
        }


        currentGameState = gameStates[gameState.getId()];

        currentGameState.start();
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public GameState[] getGameStates() {
        return gameStates;
    }
}
