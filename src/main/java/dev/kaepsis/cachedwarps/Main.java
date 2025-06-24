package dev.kaepsis.cachedwarps;

import co.aikar.commands.PaperCommandManager;
import dev.kaepsis.cachedwarps.commands.*;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.config.WarpsConfig;
import dev.kaepsis.cachedwarps.storage.WarpStorage;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin {

    public static Main instance;

    public static PaperCommandManager commandManager;

    public static HashMap<String, Location> loadedWarps;

    @Override
    public void onEnable() {
        instance = this;
        loadedWarps = new HashMap<>();
        WarpStorage.getInstance().loadWarps();
        config();
        commands();
    }

    @Override
    public void onDisable() {
        instance = null;
        WarpStorage.getInstance().unloadWarps();
    }

    void config() {
        WarpsConfig.getInstance().registerConfig(this);
        LanguageConfig.getInstance().registerConfig(this);
    }

    void commands() {
        commandManager = new PaperCommandManager(this);
        completions();
        commandManager.registerCommand(new CommandSetwarp());
        commandManager.registerCommand(new CommandWarp());
        commandManager.registerCommand(new CommandListwarps());
        commandManager.registerCommand(new CommandDelwarp());
        commandManager.registerCommand(new AdminCommand());
    }

    void completions() {
        commandManager.getCommandCompletions().registerAsyncCompletion("cachedWarps", c -> WarpStorage.getInstance().getWarpsNames());
    }

}
