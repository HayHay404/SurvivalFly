package hayhay.cc.survivalfly;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffectType;

public class milkDrinkListener implements Listener {

    @EventHandler
    public void onDrinkMilk(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();;

        if (player.isFlying()
                && event.getItem().getType() == Material.MILK_BUCKET
                && player.getGameMode() == GameMode.SURVIVAL
                && player.hasPotionEffect(PotionEffectType.HUNGER)) {
            event.setCancelled(true);
            player.getActivePotionEffects().forEach(potionEffect -> player.removePotionEffect(potionEffect.getType()));
            player.addPotionEffect(PotionEffectType.HUNGER.createEffect(99999, ConfigFile.getAmplifier()));
        }
    }
}
