package fr.acore.spigot.listener;

import fr.acore.spigot.api.player.impl.CorePlayer;
import fr.acore.spigot.manager.ABoardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ABoardListener implements Listener {

    private ABoardManager boardManager;

    public ABoardListener(ABoardManager boardManager){
        this.boardManager = boardManager;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        CorePlayer<?> corePlayer = boardManager.getCorePlayer(event.getPlayer());
        corePlayer.initBoard(boardManager.getScoreboardTitle());
        System.out.println("Initialisation du board");
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event){

    }

}
