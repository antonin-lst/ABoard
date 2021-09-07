package fr.acore.spigot.manager;

import fr.acore.spigot.api.player.impl.CorePlayer;
import fr.acore.spigot.api.plugin.module.IModule;
import fr.acore.spigot.api.runnable.IRunnable;
import fr.acore.spigot.api.runnable.RunnableUsage;
import fr.acore.spigot.listener.ABoardListener;
import fr.acore.spigot.module.AManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ABoardManager extends AManager implements IRunnable {

    private String scoreboardTitle;
    public String getScoreboardTitle() { return this.scoreboardTitle;}

    private List<String> rows;
    public List<String> getRows(){ return this.rows;}

    public ABoardManager(IModule key) {
        super(key, true);
        registerAsyncRunnable(RunnableUsage.RENDER, this);
        registerListener(new ABoardListener(this));
    }

    @Override
    public void setup(FileConfiguration config) {
        this.scoreboardTitle = convertColor(config.getString("scoreboardTitle"));
        this.rows = convertColor(config.getStringList("rows"));
        for(CorePlayer<?> corePlayer : getCorePlayer()) {
            corePlayer.initBoard(scoreboardTitle);
        }
    }

    @Override
    public void ticks() {

    }
}
