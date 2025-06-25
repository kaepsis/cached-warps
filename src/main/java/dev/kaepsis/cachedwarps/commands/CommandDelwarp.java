package dev.kaepsis.cachedwarps.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.storage.WarpStorage;
import dev.kaepsis.kmanagers.Chat;
import org.bukkit.entity.Player;

@CommandAlias("delwarp")
@CommandPermission("cachedwarps.delete")
public class CommandDelwarp extends BaseCommand {

    @Default
    public void root(Player player) {
        Chat.getInstance().send(player, LanguageConfig.getInstance().DELWARP_USAGE);
    }

    @Default
    @Syntax("<name>")
    @CommandCompletion("@cachedWarps")
    public void withName(Player player, String name) {
        if (!WarpStorage.getInstance().existsWarp(name)) {
            Chat.getInstance().send(player, LanguageConfig.getInstance().CANNOT_FIND_WARP, "$name", name);
            return;
        }
        WarpStorage.getInstance().deleteWarp(name);
        Chat.getInstance().send(player, LanguageConfig.getInstance().DELWARP_SUCESS, "$name", name);
    }

}
