package org.kaccag.rpls.characters.character;

import org.junit.Assert;
import org.junit.Test;

public class CharacterTest {

    @Test
    public void createCharacter() {
        new Character("player", "character");
    }

    @Test
    public void idIsPlayerAndCharacterAsHash() {
        Character initial = new Character("player", "character");
        Assert.assertEquals("playercharacter".hashCode(), initial.getId());
    }

    @Test
    public void createNullPlayerName() {
        try {
            new Character(null, "character");
            Assert.fail("Character should provide a non null player name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly.
        }
    }

    @Test
    public void createEmptyPlayerName() {
        try {
            new Character("", "character");
            Assert.fail("Character should provide a non empty player name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly.
        }
    }

    @Test
    public void createNullCharacterName() {
        try {
            new Character("player", null);
            Assert.fail("Character should provide a non null character name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly
        }
    }

    @Test
    public void createEmptyCharacterName() {
        try {
            new Character("player", "");
            Assert.fail("Character should provide a non empty character name");
        } catch (IllegalArgumentException e) {
            // Error was thrown correctly
        }
    }

    @Test
    public void toStringGetsIdPlayerCharacterValues() {
        String toString = new Character("player", "character").toString();
        Assert.assertEquals("Character: " + "playercharacter".hashCode()
                + ", Name: character, Player: player", toString);
    }
}
