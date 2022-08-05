package me.fenixcrafter.scratchcards;

import me.fenixcrafter.scratchcards.Commands.GiveScratchCardCommand;
import me.fenixcrafter.scratchcards.Commands.ScracthcardBuyMenu;
import me.fenixcrafter.scratchcards.Handler.ScratchcardHandler;
import me.fenixcrafter.scratchcards.Handler.ScratchcardShopHandler;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class ScratchCards extends JavaPlugin
{

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;


    private static ScratchCards plugin;

    public static Economy getEconomy()
    {
        return econ;
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
        getServer().getPluginManager().registerEvents(new ScratchcardShopHandler(), this);

        if (!setupEconomy())
        {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        System.out.println("[ScratchCard] The ScratchCard plugin has been enabled!");
    }

    private boolean setupEconomy()
    {
        if (getServer().getPluginManager().getPlugin("Vault") == null)
        {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
        {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

}
