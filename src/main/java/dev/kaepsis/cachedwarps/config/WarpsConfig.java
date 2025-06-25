package dev.kaepsis.cachedwarps.config;

import net.pino.simpleconfig.LightConfig;
import net.pino.simpleconfig.annotations.Config;
import net.pino.simpleconfig.annotations.ConfigFile;
import net.pino.simpleconfig.annotations.inside.Path;
import org.bukkit.Location;

import java.util.Map;

@Config
@ConfigFile("warps.yml")
public class WarpsConfig extends LightConfig {

    private static WarpsConfig instance = null;
    @Path("warps")
    public Map<String, Location> warps = Map.of();

    private WarpsConfig() {

    }

    public static WarpsConfig getInstance() {
        if (instance == null) {
            instance = new WarpsConfig();
        }
        return instance;
    }

}
