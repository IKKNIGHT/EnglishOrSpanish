package org.example.ikknight.templatep;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.ikknight.templatep.commands.EnglishOrSpanish;
import org.example.ikknight.templatep.commands.Reloadtp;
import org.example.ikknight.templatep.listeners.PlayerMove;
import org.example.ikknight.templatep.utils.Constants;

import static org.example.ikknight.templatep.utils.BasicUtils.setPrefix;

public final class Main extends JavaPlugin {

    PluginDescriptionFile pdfFile; // plugin.yml

    public PluginDescriptionFile getPdfFile() {
        return pdfFile;
    }

    public static boolean EOS = false;

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        this.pdfFile = getDescription();

        reloadConfiguration();
        setPrefix(getConfig().get(Constants.YAML.PREFIX_PATH));
        // init command
        this.getCommand("reloadtp").setExecutor(new Reloadtp(this));
        this.getCommand("englishorspanish").setExecutor(new EnglishOrSpanish(this));

        // init listeners
        this.getServer().getPluginManager().registerEvents(new PlayerMove(),this);
        this.getLogger()
                .info(this.pdfFile.getName() + " - Version " + this.pdfFile.getVersion() + " - has been enabled!");
    }
    public void configureFile(){
        // configures config.yml
        getConfig().addDefault(Constants.YAML.PREFIX_PATH,Constants.DEFAULT_SUFFIX_VALUE);
    }
    public void reloadConfiguration(){
        configureFile();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
