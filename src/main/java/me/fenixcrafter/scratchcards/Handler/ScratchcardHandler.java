package me.fenixcrafter.scratchcards.Handler;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class ScratchcardHandler extends ScratchCardItem implements Listener
{

    @EventHandler
    public void onScratchcardUse(PlayerInteractEvent e)
    {
        System.out.println("1");
        Player player = e.getPlayer();
        System.out.println(player.getInventory().getItemInMainHand());
        System.out.println(ScratchCardItem.getItem());


        if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand() == ScratchCardItem.getItem())
        {
            System.out.println("2");
            player.getInventory().remove(player.getInventory().getItemInMainHand());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Je hebt gewonnen"));

        } else {
            System.out.println("false");
        }

    }

}
