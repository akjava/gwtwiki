/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;

/**
 * 
 *
 */
public abstract class AbstractCommandParser implements LineParser{
protected boolean isCommand(String line){
    return line.startsWith("#") && !line.startsWith("##");
}
public String getCommandName(String line){
    int index=line.indexOf("(");
    if(index==-1){
        index=line.length();
    }
    return line.substring(1,index);
}
public String[] parseAttributes(String line){
    int index=line.indexOf("(");
    if(index==-1){
        return new String[0];
    }else{
        int last=line.lastIndexOf(")");
        if(last==-1){
            last=line.length();
            System.out.println("forget )");
        }
        //Math.max(last,);//for forget );
        String ats=line.substring(index+1,last);
        return ats.split(",");
    }
}


}
