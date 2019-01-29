package org.kaccag.rpls.characters.character;

import org.junit.Assert;
import org.junit.Test;

public class CharacterTest {

    @Test
    public void createCharacter() {
        Character initial = new Character("player", "character");
    }

    @Test
    public void idIsPlayerAndCharacterAsHash() {
        Character initial = new Character("player", "character");
        Assert.assertEquals("playercharacter".hashCode(), initial.getId());
    }

    @Test
    public void createCharacterWithNullPlayerName() {
        try {
            Character initial = new Character(null, "character");
            Assert.fail("Character should provide a non null player name");
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void createCharacterWithEmptyPlayerName() {
        try {
            Character initial = new Character("", "character");
            Assert.fail("Character should provide a non null player name");
        } catch (IllegalArgumentException e) {}
    }
}
