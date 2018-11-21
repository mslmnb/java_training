package com.epam.string.firsttask;

public class CharacterCounter implements Comparable<CharacterCounter>{
    private char character;
    private int  count;

    public CharacterCounter(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public void incrementCount() {
        count++;
    }

    @Override
    public int compareTo(CharacterCounter counter) {
        return (counter == null)
                ? 1
                : ((counter.count != this.count)
                ? this.count - counter.count
                : this.character - counter.character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterCounter)) return false;

        CharacterCounter that = (CharacterCounter) o;

        return character == that.character;

    }

    @Override
    public int hashCode() {
        return (int) character;
    }

    @Override
    public String toString() {
        return "['" + character +
                "', " + count +
                ']';
    }
}

