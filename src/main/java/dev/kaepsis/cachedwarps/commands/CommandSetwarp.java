package dev.kaepsis.cachedwarps.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import com.github.kaepsis.Chat;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.storage.WarpStorage;
import dev.kaepsis.kmanagers.Chat;
import org.bukkit.entity.Player;

@CommandAlias("setwarp")
@CommandPermission("cachedwarps.set")
public class CommandSetwarp extends BaseCommand {

    @Default
    public void root(Player player) {
        Chat.getInstance().send(player, LanguageConfig.getInstance().SETWARP_USAGE);
    }

    @Default
    @Syntax("<name>")
    public void withName(Player player, String name) {
        if (WarpStorage.getInstance().existsWarp(name)) {
            Chat.getInstance().send(player, LanguageConfig.getInstance().SETWARP_ALREADY_EXISTS, "$name", name);
            return;
        }
        WarpStorage.getInstance().createWarp(player, name);
        Chat.getInstance().send(player, LanguageConfig.getInstance().SETWARP_SUCCESS, "$name", name);
    }

}
