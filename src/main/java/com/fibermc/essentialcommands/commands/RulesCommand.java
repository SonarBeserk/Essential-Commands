package com.fibermc.essentialcommands.commands;

import com.fibermc.essentialcommands.ECText;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.jpcode.eccore.util.TextUtil;
import eu.pb4.placeholders.PlaceholderAPI;
import eu.pb4.placeholders.TextParser;
import net.minecraft.server.command.ServerCommandSource;

import static com.fibermc.essentialcommands.EssentialCommands.CONFIG;

public class RulesCommand implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        var text = TextParser.parse(CONFIG.RULES.getValue());
        var message = PlaceholderAPI.parseText(text, context.getSource().getPlayer());

        context.getSource().sendFeedback(TextUtil.concat(
                ECText.getInstance().getText("cmd.rules.header"),
                message
        ), false);

        return 0;
    }
}
