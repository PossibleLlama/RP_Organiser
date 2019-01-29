package org.kaccag.rpls.characters.character;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {

    private Character.Builder builder;

    @Before
    public void setupCharacterBuilder() {
        builder = new Character.Builder()
                .setPlayerName("player")
                .setCharacterName("character");
    }

    @Test
    public void createCharacter() {
        builder.build();
    }

    @Test
    public void idIsPlayerAndCharacterAsHash() {
        Character initial = builder.build();
        Assert.assertEquals("playercharacter".hashCode(), initial.getId());
    }

    @Test
    public void createNullPlayerName() {
        try {
            builder.setPlayerName(null).build();
            Assert.fail("Character should provide a non null player name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly.
        }
    }

    @Test
    public void createEmptyPlayerName() {
        try {
            builder.setPlayerName("").build();
            Assert.fail("Character should provide a non empty player name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly.
        }
    }

    @Test
    public void createNullCharacterName() {
        try {
            builder.setCharacterName(null).build();
            Assert.fail("Character should provide a non null character name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly
        }
    }

    @Test
    public void createEmptyCharacterName() {
        try {
            builder.setCharacterName("").build();
            Assert.fail("Character should provide a non empty character name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly
        }
    }

    @Test
    public void toStringGetsIdPlayerCharacterValues() {
        String toString = builder.build().toString();
        Assert.assertEquals("Character: " + "playercharacter".hashCode()
                + ", Name: character, Player: player", toString);
    }
}
