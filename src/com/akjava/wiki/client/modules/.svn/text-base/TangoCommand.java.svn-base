/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.modules;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.ElementImp;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.parser.CodeCommandParser;
import com.akjava.wiki.client.parser.TextCommandParser;
import com.akjava.wiki.client.parser.TextLineParser;
import com.akjava.wiki.client.parser.TopicParser;

/**
 * 
 *
 */
public class TangoCommand extends ElementImp{
    
    public TangoCommand(){
    setName("code");
    }

    public LineParser[] getLineParses() {
        // TODO Auto-generated method stub
        return new LineParser[]{TopicParser.getInstance(),TextCommandParser.getInstance(),CodeCommandParser.getInstance(),new TextLineParser()};
    }
    
    public StringParser[] getStringParses() {
        // TODO Auto-generated method stub
        return new StringParser[]{};
    }
    
    public Element breakUp(Element element,String line){
        if(line.startsWith("#text") || line.startsWith("*")){
            return element.getParent();
        }
        return element;
    }
}
