package de.bypixels.spleef.util.countdowns;

import de.bypixels.spleef.Spleef;
import de.bypixels.spleef.gamestates.GameStatesEnums;
import de.bypixels.spleef.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyCountDown extends CountDown {


    private Spleef plugin;


    public LobbyCountDown(Spleef plugin) {
        this.plugin = plugin;
    }

    private static int TaskID, idleID;
    private static int MIN_PLAYERS;

    private static boolean isIdle = true;
    private static int Countdown = (int) Spleef.getPlugin().getSettings().getValue("LOBBY_DELAY");

    @Override
    public void start() {
        try {
            Bukkit.getScheduler().cancelTask(idleID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {
                MIN_PLAYERS = (int) Spleef.getPlugin().getSettings().getValue("MIN_PLAYERS");
                if (Variables.getPlayers().size() >= MIN_PLAYERS) {


                    Countdown--;
                    isIdle = false;

                    switch (Countdown) {
                        case 60:
                            sendTimeLeft();
                            break;
                        case 45:
                            sendTimeLeft();
                        case 25:
                            sendTimeLeft();
                            break;
                        case 30:
                            sendTimeLeft();
                            break;
                        case 20:
                            sendTimeLeft();
                            break;
                        case 15:
                            sendTimeLeft();
                            break;
                        case 10:
                            sendTimeLeft();
                            break;
                        case 9:
                            sendTimeLeft();
                            break;
                        case 8:
                            sendTimeLeft();
                            break;
                        case 7:
                            sendTimeLeft();
                            break;
                        case 6:
                            sendTimeLeft();
                            break;
                        case 5:
                            sendTimeLeft();
                            break;
                        case 4:
                            sendTimeLeft();
                            break;
                        case 3:
                            sendTimeLeft();
                            break;
                        case 2:
                            sendTimeLeft();
                            break;
                        case 1:
                            sendTimeLeft();
                            break;
                        case 0:


                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + Spleef.getPlugin().getMessages().getStringWithColor("START_GAME"));
                            }
                            Spleef.getPlugin().getGameStateHandler().setCurrentGameState(GameStatesEnums.INGAME_STATE);

                            Spleef.getPlugin().getExtra().syncDataFiles(Variables.getPlayers(), Spleef.getPlugin().getUtility().getShowenPlayers());
                            Spleef.getPlugin().getExtra().syncDataFiles(Variables.getSpectators(), Spleef.getPlugin().getUtility().getHiddenPlayers());
                            Spleef.getPlugin().getUtility().hideHiddenPlayersFromShowen();
                            break;
                    }

                } else {
                    isIdle = true;

                    startIdle();


                }
            }
        }, 20, 20);


    }


    private int sec = 15;

    public static int missingPlayers = MIN_PLAYERS - Variables.getPlayers().size();

    private void startIdle() {
        if (isIdle == true) {
            try {
                Bukkit.getScheduler().cancelTask(TaskID);
            } catch (Exception e) {
                e.printStackTrace();
            }

            idleID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                @Override
                public void run() {
                    missingPlayers = MIN_PLAYERS - Variables.getPlayers().size();
                    //     for (UUID id : Variables.getPlayers()) Bukkit.broadcastMessage(Bukkit.getPlayer(id).getName());
                    sec--;
                    if (Variables.getPlayers().size() < MIN_PLAYERS) {
                        if (sec == 0) {



                                Bukkit.getServer().broadcastMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + Spleef.getPlugin().getMessages().getStringWithColor("MISSING_PLAYERS").replaceAll("%player%", Integer.toString(missingPlayers)));

                            sec = 15;
                        }
                    } else if (Variables.getPlayers().size() >= MIN_PLAYERS) {
                        Countdown = (int) Spleef.getPlugin().getSettings().getValue("LOBBY_DELAY");
                        isIdle = false;
                        start();

                    }


                }
            }, 20, 20);

        }
    }

    private static void sendTimeLeft() {

        for (Player players : Bukkit.getOnlinePlayers())
            players.playSound(players.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
        Bukkit.broadcastMessage(Spleef.getPlugin().getMessages().getStringWithColor("Prefix") + Spleef.getPlugin().getMessages().getStringWithColor("COUNTDOWN_LEFT").replaceAll("%time%", Integer.toString(Countdown)));

    }

    @Override
    public void stop() {

    }
}
