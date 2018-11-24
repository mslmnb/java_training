package com.epam.string.secondtask.model;

import java.util.List;

public interface TextComponent {
    void parse();
    TextComponentType getType();
    String getSourceText();
    List<TextComponent> getOwnChilds();
    List<TextComponent> getChildsByType(TextComponentType type);
    boolean isComposite();
}
