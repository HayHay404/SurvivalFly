package hayhay.cc.survivalfly;

public class ConfigFile {
    public static int getAmplifier() {
        return Integer.parseInt(SurvivalFly.getConfigFile().getConfig().getString("hunger-amplifier")) - 1;
    }

    public static float getFlySpeed() {
        return Float.parseFloat(SurvivalFly.getConfigFile().getConfig().getString("fly-speed"));
    }
}
