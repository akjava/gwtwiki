package com.akjava.gwt.wiki.client;

public interface TextInsertTarget {
public void insertText(String text);
public void tagText(String header,String footer);
public void insertAndCursorCenter(String header,String footer);
}
