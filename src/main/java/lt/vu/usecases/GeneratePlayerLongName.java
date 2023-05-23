package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.PlayerName;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.inject.Named;

@SessionScoped
@Named
public class GeneratePlayerLongName implements Serializable {
    @Inject
    PlayerName playerName;
    private CompletableFuture<String> playerNameGenerationTask = null;

    @LoggedInvocation
    public String generateNewPlayerName() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        playerNameGenerationTask = CompletableFuture.supplyAsync(() -> playerName.getName());

        return  "/playerDetails.xhtml?faces-redirect=true&playerId=" + requestParameters.get("playerId");
    }

    public boolean isNameGenerationRunning() {
        return playerNameGenerationTask != null && !playerNameGenerationTask.isDone();
    }

    public String getPlayerNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (playerNameGenerationTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "Player name loading...";
        }
        return "Suggested player name: " + playerNameGenerationTask.get();
    }
}
