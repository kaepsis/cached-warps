package dev.kaepsis.cachedwarps.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.github.kaepsis.Chat;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.storage.WarpStorage;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;


@CommandAlias("listwarps|warps")
public class CommandListwarps extends BaseCommand {

    @Default
    public void root(Player player) {
        int warpsCount = WarpStorage.getInstance().getWarpsNames().size();
        if (warpsCount == 0) {
            Chat.getInstance().send(player, LanguageConfig.getInstance().NO_WARPS_DEFINED);
            return;
        }
        Chat.getInstance().send(
                player,
                LanguageConfig.getInstance().WARP_LIST,
                "$count", WarpStorage.getInstance().getWarpsNames().size(),
                "$warps", StringUtils.join(WarpStorage.getInstance().getWarpsNames(), " ")
        );
    }

}
