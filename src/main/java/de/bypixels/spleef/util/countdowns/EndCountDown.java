package de.bypixels.spleef.util.countdowns;

import de.bypixels.spleef.Spleef;

public class EndCountDown extends CountDown {


    private static int Countdown = (int) Spleef.getPlugin().getSettings().getValue("END_DELAY") * 20;

    @Override
    public void start() {


        stop();
    }


    @Override
    public void stop() {

    }
}
