package me.fenixcrafter.scratchcards.Handler;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import me.fenixcrafter.scratchcards.ScratchCards;
import net.milkbowl.vault.economy.EconomyResponse;
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

            if (ScratchCards.getEconomy().getBalance(p.getName()) >= ScratchCards.getPlugin().getConfig().getDouble("Cost"))
            {


                p.getInventory().addItem(ScratchCardItem.getItem());
                EconomyResponse r = ScratchCards.getEconomy().withdrawPlayer(p.getName(), ScratchCards.getPlugin().getConfig().getInt("PayOut"));

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aJe hebt een kraslot gekocht voor " + ScratchCards.getPlugin().getConfig().get("PayOut") + " euro"));
            } else
            {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cJe hebt niet genoeg geld voor een kraslot"));
            }
        }
    }
}
