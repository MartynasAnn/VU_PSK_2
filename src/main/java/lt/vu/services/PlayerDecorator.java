package lt.vu.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import lt.vu.mybatis.model.Player;

import java.util.List;
import java.util.Random;

@Decorator
public abstract class PlayerDecorator implements PlayerName {
    @Inject
    private GamertagList gamertagList;

    @Inject @Delegate
    protected PlayerName playerName;
    Player currentPlayer = new Player();

    private String getRandomGamertag() {
        List<String> gamertags = gamertagList.getGamertags();
        Random random = new Random();
        return gamertags.get(random.nextInt(gamertags.size()));
    }

    public String getName() {
        String gamertag = getRandomGamertag();
        return playerName.getName() + ", also known as " + gamertag + ", member of the International Gaming League.";
    }
}
