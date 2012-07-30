package com.akjava.wiki.client.ecs;

public class IFrame {
private String src;
private String scrolling;
private boolean frameBorder;
private int marginWidth;
private int marginHeight;
private String style;
public String toString(){
	return "<iframe src='"+src+"' scrolling="+scrolling+" frameborder="+frameBorder+" marginWidth="+marginWidth+" marginHeight="+marginHeight+" style='"+style+"'></iframe>";
}
public String getSrc() {
	return src;
}
public void setSrc(String src) {
	this.src = src;
}
public String getScrolling() {
	return scrolling;
}
public void setScrolling(String scrolling) {
	this.scrolling = scrolling;
}

public int getMarginWidth() {
	return marginWidth;
}
public void setMarginWidth(int marginWidth) {
	this.marginWidth = marginWidth;
}
public int getMarginHeight() {
	return marginHeight;
}
public void setMarginHeight(int marginHeight) {
	this.marginHeight = marginHeight;
}
public boolean isFrameBorder() {
	return frameBorder;
}
public void setFrameBorder(boolean frameBorder) {
	this.frameBorder = frameBorder;
}
public String getStyle() {
	return style;
}
public void setStyle(String style) {
	this.style = style;
}
}
