package me.fenixcrafter.scratchcards.CustomItems;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ScratchCardItem
{
    public static ItemStack getItem()
    {
        ItemStack item = new ItemStack(Material.PAPER, 1);

        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&lKraslot"));
//        short dur = 1;
//        item.setDurability(dur);
        meta.setUnbreakable(true);
//        List<String> list = new ArrayList<String>();
//        list.add(ChatColor.translateAlternateColorCodes('&', "&4Officieel item"));
//        meta.setLore(list);
        item.setItemMeta(meta);
        return item;
    }
}
