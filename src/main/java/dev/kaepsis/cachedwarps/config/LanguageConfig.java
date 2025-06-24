package dev.kaepsis.cachedwarps.config;

import net.pino.simpleconfig.BaseConfig;
import net.pino.simpleconfig.annotations.Config;
import net.pino.simpleconfig.annotations.ConfigFile;
import net.pino.simpleconfig.annotations.inside.Path;

@Config
@ConfigFile("lang.yml")
public class LanguageConfig extends BaseConfig {

    private static LanguageConfig instance;

    public static LanguageConfig getInstance() {
        if (instance == null) {
            instance = new LanguageConfig();
        }
        return instance;
    }

    private LanguageConfig() {
    }

    @Path("errors.cannot-find-warp")
    public String CANNOT_FIND_WARP = "&9&lWARPS &8| &cCouldn't find a warp named $name";

    @Path("setwarp.usage")
    public String SETWARP_USAGE = "&9&lWARPS &8| &cCorrect usage is /setwarp <name>";

    @Path("setwarp.already-exists")
    public String SETWARP_ALREADY_EXISTS = "&9&lWARPS &8| &cA warp named $name already exists";

    @Path("setwarp.created")
    public String SETWARP_SUCCESS = "&9&lWARPS &8| &aCreated warp &f$name &aat your location";

    @Path("warp.usage")
    public String WARP_USAGE = "&9&lWARPS &8| &cCorrect usage is /warp <name>";

    @Path("warp.teleported")
    public String WARP_TELEPORTED = "&9&lWARPS &8| &aYou've been teleported to warp &f$name";

    @Path("warp.list")
    public String WARP_LIST = "&9&lWARPS &8| &aThere are &f$count &aavailable warps&7: &f$warps";

    @Path("delwarp.usage")
    public String DELWARP_USAGE = "&9&lWARPS &8| &cCorrect usage is /delwarp <name>";

    @Path("delwarp.success")
    public String DELWARP_SUCESS = "&9&lWARPS &8| &aDeleted warp &f$name";

    @Path("config-reloaded")
    public String CONFIG_RELOADED = "&9&lWARPS &8| &aConfig has been reloaded successfully";

}
