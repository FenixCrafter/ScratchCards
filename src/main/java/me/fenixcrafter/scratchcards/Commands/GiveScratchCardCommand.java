package me.fenixcrafter.scratchcards.Commands;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveScratchCardCommand extends ScratchCardItem implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player p && p.hasPermission("scratchcards.give"))
        {

            if (args.length == 0)
            {
                p.getInventory().addItem(ScratchCardItem.getItem());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aJe hebt een kraslot gekregen!"));
                return true;
            } else if (sender.getServer().getPlayer(args[0]) != null)
            {
                Player target = sender.getServer().getPlayer(args[0]);

                target.getInventory().addItem(ScratchCardItem.getItem());
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aJe hebt een kraslot gekregen!"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lJe hebt &6&l" + target.getDisplayName() + " &4&leen kraslot gegeven!"));
            }
        }

//        if (args.length == 1)
//        {
//            if (sender.hasPermission("scratchcard.give"))
//            {
//                if (sender.getServer().getPlayer(args[0]) != null)
//                {
//                    sender.getServer().getPlayer(args[0]).getInventory().addItem(ScratchCard.getInstance().getScratchCard());
//                    sender.sendMessage("[ScratchCard] You gave " + sender.getServer().getPlayer(args[0]).getName() + " a ScratchCard!");
//                }
//                else
//                {
//                    sender.sendMessage("[ScratchCard] Player not found!");
//                }
//            }
//            else
//            {
//                sender.sendMessage("[ScratchCard] You don't have permission to use this command!");
//            }
//        }
//        else
//        {
//            sender.sendMessage("[ScratchCard] Usage: /give <player>");
//        }

        return true;
    }
}
