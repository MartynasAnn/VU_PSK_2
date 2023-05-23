package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultPlayerName implements PlayerName{

    @Override
    public String getName() {
        return "Player ";
    }
}
