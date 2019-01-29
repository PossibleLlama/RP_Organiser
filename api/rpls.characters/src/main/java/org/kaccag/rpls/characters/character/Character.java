package org.kaccag.rpls.characters.character;

public class Character {

    private Integer id;

    private String playerName;
    private String characterName;

    public Character(final String playerName, final String characterName) {
        if (playerName == null || playerName.equals(""))
            throw new IllegalArgumentException("Player name must be non null and not empty.");
        this.playerName = playerName;
        this.characterName = characterName;

        this.id = (playerName + characterName).hashCode();
    }

    public int getId() {
        return id != null ? id : 0;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return String.format("Character: %s, Name: %s, Player: %s",
                this.id, this.characterName, this.playerName);
    }
}
