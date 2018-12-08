package com.epam._old.string.secondtask.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextComposite implements TextComponent{
    private TextComponentType type;
    private String sourceText;
    private List<TextComponent> ownChilds;

    public TextComposite(TextComponentType type, String sourceText) {
        this.type = type;
        this.sourceText = sourceText;
    }

    @Override
    public void parse() {
        TextComponentType[] types = TextComponentType.values();
        Pattern pattern = Pattern.compile(type.getRegex());
        String[] strings = pattern.split(sourceText);
        TextComponentType childType = types[type.ordinal() + 1];
        ownChilds = Arrays.stream(strings).map(s -> new TextComposite(childType, s)).collect(Collectors.toList());

        ownChilds.stream().filter(TextComponent::isComposite).forEach(TextComponent::parse);
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public String getSourceText() {
        return sourceText;
    }

    @Override
    public List<TextComponent> getOwnChilds() {
        return ownChilds;
    }

    @Override
    public List<TextComponent> getChildsByType(TextComponentType type) {
        List<TextComponent> resultList = new ArrayList<>();
        if (type.isOwnChild(this.type)) {
            resultList = ownChilds;
        } else if (this.type.ordinal() < type.ordinal()) {
            for (TextComponent component: ownChilds) {
                List<TextComponent> componentChilds = component.getChildsByType(type);
                if (componentChilds != null) {
                    resultList.addAll(component.getChildsByType(type));
                }
            }
        }
        return resultList;
    }

    @Override
    public boolean isComposite() {
        return type.isComposite();
    }

    @Override
    public String toString() {
        return sourceText;
    }
}
