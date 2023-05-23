package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;


@Named
@ApplicationScoped
public class GamertagList {
    public static final List<String> GAMERTAGS = Arrays.asList(
            "ShadowSlayer",
            "NinjaWarrior",
            "EpicGamer",
            "MasterChief",
            "SonicSpeed",
            "Dragonborn",
            "PixelNinja",
            "SteelTitan",
            "PhantomAssassin",
            "CyberSamurai"
    );

    public List<String> getGamertags() {
        return GAMERTAGS;
    }
}