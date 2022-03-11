package hayhay.cc.survivalfly;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class FlightToggle {
    public static void togglePlayerFly(Player player) {
        if (!player.getAllowFlight()) {
            player.setAllowFlight(player.getFoodLevel() > 3);
            player.addPotionEffect(PotionEffectType.HUNGER.createEffect(99999, ConfigFile.getAmplifier()));
            player.setFlySpeed(ConfigFile.getFlySpeed());
            player.sendMessage("Up, Up and away!");
        } else {
            player.setFlying(false);
            // TODO: Safely teleport player down to ground.
            player.setAllowFlight(false);
            player.removePotionEffect(PotionEffectType.HUNGER);
        }
    }
}
