package pl.gamma;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.java.JavaPlugin;

public class GammaPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("gamma").setExecutor(this);
        getLogger().info("Plugin Gamma zostal wlaczony!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Gamma zostal wylaczony!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gamma")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    player.sendMessage("§aEfekty Widzenia w ciemności zostały wyłączone.");
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false));
                    player.sendMessage("§aEfekty Widzenia w ciemności zostały włączone.");
                }
                return true;
            } else {
                sender.sendMessage("§cTylko gracz może użyć tej komendy!");
                return false;
            }
        }
        return false;
    }
}