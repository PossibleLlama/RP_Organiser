package org.kaccag.rpls.characters.character;

public class Character {

    private Integer id;

    private String playerName;
    private String characterName;

    public Character(final String playerName, final String characterName) {
        this.id = (playerName + characterName).hashCode();

        this.playerName = playerName;
        this.characterName = characterName;
    }

    public Integer getId() {
        return id;
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
