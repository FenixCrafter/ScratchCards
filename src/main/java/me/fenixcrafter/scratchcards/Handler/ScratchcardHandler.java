package me.fenixcrafter.scratchcards.Handler;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import me.fenixcrafter.scratchcards.ScratchCards;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class ScratchcardHandler extends ScratchCardItem implements Listener
{

    @EventHandler
    public void onScratchcardUse(PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().isSimilar(ScratchCardItem.getItem()))
        {

            int chanse = ScratchCards.getPlugin().getConfig().getInt("Chanse");
            double num = Math.random();
            int myRandInt = (int) (num * chanse + 1);

            if (myRandInt == 1)
            {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Je hebt " + ScratchCards.getPlugin().getConfig().getInt("PayOut") + " gewonnen"));
                Economy econ = ScratchCards.getEconomy();
                EconomyResponse r = econ.depositPlayer(player.getName(), ScratchCards.getPlugin().getConfig().getInt("PayOut"));
            } else
            {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Je hebt verloren"));
            }

            player.getInventory().removeItem(ScratchCardItem.getItem());


        }

    }

}
