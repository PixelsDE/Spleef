package de.bypixels.spleef.gamestates;

public enum GameStatesEnums {


    LOBBY_STATE(0, "Lobby Phase"), INGAME_STATE(1, "Ingame Phase"), END_STATE(2, "End Phase");

    private int id;
    private  String name;

    GameStatesEnums(int id) {
        this.id = id;
    }


    GameStatesEnums(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
