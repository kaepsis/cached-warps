package dev.kaepsis.cachedwarps.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import com.github.kaepsis.Chat;
import dev.kaepsis.cachedwarps.config.LanguageConfig;
import dev.kaepsis.cachedwarps.config.WarpsConfig;
import dev.kaepsis.kmanagers.Chat;
import org.bukkit.command.CommandSender;

@CommandAlias("acw")
@CommandPermission("cachedwarps.admin")
public class AdminCommand extends BaseCommand {

    @Subcommand("reload")
    public void reload(CommandSender sender) {
        LanguageConfig.getInstance().reload();
        WarpsConfig.getInstance().reload();
        Chat.getInstance().send(sender, LanguageConfig.getInstance().CONFIG_RELOADED);
    }

}
