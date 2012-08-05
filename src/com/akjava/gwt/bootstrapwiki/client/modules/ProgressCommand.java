/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.ElementImp;

/**
 * 
 *
 */
public class ProgressCommand extends ElementImp{
public ProgressCommand(){
    setName("progress");
}
private String persent;
private String type;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private int width=300;
private String color;
public String getPersent() {
	return persent;
}
public void setPersent(String persent) {
	this.persent = persent;
}

public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}





}
