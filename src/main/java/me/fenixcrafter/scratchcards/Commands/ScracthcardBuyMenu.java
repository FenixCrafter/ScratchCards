package me.fenixcrafter.scratchcards.Commands;

import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class ScracthcardBuyMenu implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if (sender instanceof Player p)
        {
            Inventory scratchcardShop = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&6&lScratchcard shop"));

//            ItemStack opvulling = new ItemStack(Material.);
//            ItemMeta opvullingMeta = opvulling.getItemMeta();

//            opvullingMeta.setDisplayName(" ");
//            opvulling.setItemMeta(opvullingMeta);

//            for(int x = 0;x <= 26;x++){
//            scratchcardShop.setItem(x,opvulling);
//        }
            ItemStack card = ScratchCardItem.getItem();
            ItemMeta cardMeta = card.getItemMeta();
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.translateAlternateColorCodes('&', "&2&l$1000"));

            cardMeta.setLore(lore);
            card.setItemMeta(cardMeta);
            scratchcardShop.setItem(13, card);
            p.openInventory(scratchcardShop);
        }
        return true;
    }
}