package dev.kaepsis.cachedwarps.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.storage.WarpStorage;
import dev.kaepsis.kmanagers.Chat;
import org.bukkit.entity.Player;

@CommandAlias("warp")
public class CommandWarp extends BaseCommand {

    @Default
    public void root(Player player) {
        Chat.getInstance().send(player, LanguageConfig.getInstance().WARP_USAGE);
    }

    @Default
    @Syntax("<name>")
    public void withName(Player player, String name) {
        if (!WarpStorage.getInstance().existsWarp(name)) {
            Chat.getInstance().send(player, LanguageConfig.getInstance().CANNOT_FIND_WARP, "$name", name);
            return;
        }
        WarpStorage.getInstance().teleportToWarp(player, name);
        Chat.getInstance().send(player, LanguageConfig.getInstance().WARP_TELEPORTED, "$name", name);
    }

}
