package me.fenixcrafter.scratchcards;

import me.fenixcrafter.scratchcards.Commands.GiveScratchCardCommand;
import me.fenixcrafter.scratchcards.Commands.ScracthcardBuyMenu;
import me.fenixcrafter.scratchcards.CustomItems.ScratchCardItem;
import me.fenixcrafter.scratchcards.Handler.ScratchcardHandler;
import me.fenixcrafter.scratchcards.Handler.ScratchcardShopHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScratchCards extends JavaPlugin
{
    private static ScratchCards plugin;
    @Override
    public void onEnable()
    {
        // Plugin startup logic

        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("giveScratchcard").setExecutor(new GiveScratchCardCommand());
        getCommand("scratchcardShop").setExecutor(new ScracthcardBuyMenu());
        getServer().getPluginManager().registerEvents(new ScratchcardHandler(), this);
        getServer().getPluginManager().registerEvents(new ScratchcardShopHandler(),this);

        System.out.println("[ScratchCard] The ScratchCard plugin has been enabled!");
    }

    public void onDisable()
    {
        // Plugin startup logic
        saveDefaultConfig();
        System.out.println("[ScratchCard] The ScratchCard plugin has been disabled!");
    }

    public static ScratchCards getPlugin()
    {
        return plugin;
    }
}
