package dev.kaepsis.cachedwarps.storage;

import dev.kaepsis.cachedwarps.Main;
import dev.kaepsis.cachedwarps.config.WarpsConfig;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class WarpStorage {

    private static WarpStorage instance = null;

    private WarpStorage() {
    }

    public static WarpStorage getInstance() {
        if (instance == null) {
            instance = new WarpStorage();
        }
        return instance;
    }

    public void loadWarps() {
        Main.loadedWarps.putAll(WarpsConfig.getInstance().warps);
    }

    public void unloadWarps() {
        Main.loadedWarps.clear();
        Main.loadedWarps = null;
    }

    public List<String> getWarpsNames() {
        return Main.loadedWarps.keySet().stream().toList();
    }

    public boolean existsWarp(String warpName) {
        return Main.loadedWarps.containsKey(warpName);
    }

    private Location getWarpLocation(String warpName) {
        return Main.loadedWarps.get(warpName);
    }

    public void teleportToWarp(Player player, String warpName) {
        player.teleport(getWarpLocation(warpName));
    }

    public void createWarp(Player player, String warpName) {
        WarpsConfig.getInstance().warps.put(warpName, player.getLocation());
        WarpsConfig.getInstance().reload();
        Main.loadedWarps.put(warpName, player.getLocation());
    }

    public void deleteWarp(String warpName) {
        WarpsConfig.getInstance().warps.remove(warpName);
        WarpsConfig.getInstance().reload();
        Main.loadedWarps.remove(warpName);
    }

}
