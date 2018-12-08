package com.epam._old.string.secondtask.model;

public enum TextComponentType {
    TEXT             ("\\r\\n"),
    PARAGRAF         ("[.!?]\\s*"),
    SENTENCE         ("[,:;]?\\s+"),
    WORD             (""),
    SYMBOL           (null);

    String regex;

    TextComponentType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public boolean isComposite() {
        return regex != null;
    }

    public boolean isOwnChild(TextComponentType type) {
        return this.ordinal() - type.ordinal() == 1;
    }
}
