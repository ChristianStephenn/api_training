package fr.esiea.ex4A.MetMock;

public class MatcheInfo {

    private final String name;
    private final String twitter;

    public MatcheInfo(String userName, String userTweeter) {
        this.name = userName;
        this.twitter = userTweeter;
    }

    public String getName() {
        return name;
    }

    public String getTwitter() {
        return twitter;
    }
}
