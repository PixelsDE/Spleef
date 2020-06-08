package de.bypixels.spleef.gamestates;

import de.bypixels.spleef.util.countdowns.EndCountDown;

public class Ingame extends GameState {

    @Override
    public void start() {

    }

    @Override
    public void stop() {


        EndCountDown countDown = new EndCountDown();

        countDown.start();
    }
}
