package dev.kaepsis.cachedwarps.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.storage.WarpStorage;
import dev.kaepsis.kmanagers.Chat;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;


@CommandAlias("listwarps|warps")
public class CommandListwarps extends BaseCommand {

    @Default
    public void root(Player player) {
        Chat.getInstance().send(
                player,
                LanguageConfig.getInstance().WARP_LIST,
                "$count", WarpStorage.getInstance().getWarpsNames().size(),
                "$warps", StringUtils.join(WarpStorage.getInstance().getWarpsNames(), " ")
        );
    }

}
