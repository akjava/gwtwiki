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
public class Small extends ElementImp{
public Small(){
    setName("small");
}
public Small(String content){
    this();
    addAttribute(content);
}


}
