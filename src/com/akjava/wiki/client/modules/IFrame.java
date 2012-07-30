/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.modules;

import com.akjava.wiki.client.core.ElementImp;

/**
 * 
 *
 */
public class IFrame extends SimpleCommand{
public IFrame(){
    setName("iframe");
}
public IFrame(String url,String width,String height){
    this();
    addAttribute(url);
    addAttribute(width);
    addAttribute(height);
}
public String getSrc(){
    return getAttributes()[0];
}
public String getWidth(){
    return getAttributes()[1];
}

public String getHeight(){
    return getAttributes()[2];
}
}
