package hayhay.cc.survivalfly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.logging.Logger;
import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getPlayerExact;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 0 && sender instanceof Player) {
            Player player = (Player) sender;

            FlightToggle.togglePlayerFly(player);

        } else if (args.length == 1 &&
                (sender instanceof Player || sender instanceof ConsoleCommandSender)) {

            if (!sender.hasPermission("survivalfly.toggle.others")) return false;

            String playerName = args[0];

            Player player = getPlayerExact(playerName);
            if (player != null) {
                FlightToggle.togglePlayerFly(player);
                Logger log = getLogger();
                log.info("Toggled survivalfly for " + args[0]);
            } else {
                sender.sendMessage("Please input a valid player name.");
            }
        }

        return true;
    }


}
