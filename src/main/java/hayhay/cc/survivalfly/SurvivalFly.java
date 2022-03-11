package hayhay.cc.survivalfly;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class SurvivalFly extends JavaPlugin {

    static SurvivalFly getConfigFile() {
        return SurvivalFly.getPlugin(SurvivalFly.class);
    }

    Logger log = getLogger();

    @Override
    public void onEnable() {

        log.info("SurvivalFly has now started.");

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new milkDrinkListener(), this);
        // getServer().getPluginManager().registerEvents(new onFlyCancel(), this);
        this.getCommand("survivalfly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        log.info("SurvivalFly is disabled.");
    }
}
