package me.fenixcrafter.scratchcards.Handler;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ScratchcardShopHandler implements Listener
{

    @EventHandler
    public void onShopItemClick(InventoryClickEvent e)
    {

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&6&lScratchcard shop")))
        {
            e.setCancelled(true);
            Player p = (Player) e.getView().getPlayer();

            p.getInventory().addItem(ScratchCardItem.getItem());
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aJe hebt een kraslot gekocht!"));

        }
    }
}
