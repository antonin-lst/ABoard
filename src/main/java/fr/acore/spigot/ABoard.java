package fr.acore.spigot;


import fr.acore.spigot.manager.ABoardManager;
import fr.acore.spigot.module.AModule;

public class ABoard extends AModule {

    @Override
    public void onEnable() {
        super.onEnable();
        registerManager(new ABoardManager(this));
        log("ABoard Enabled");
    }
}
