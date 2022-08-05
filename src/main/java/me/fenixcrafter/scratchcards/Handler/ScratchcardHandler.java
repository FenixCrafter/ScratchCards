package me.fenixcrafter.scratchcards.Handler;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import net.md_5.bungee.api.ChatColor;
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
            System.out.println("2");
            player.getInventory().removeItem(ScratchCardItem.getItem());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Je hebt gewonnen"));

        }

    }

}
