/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import java.util.ArrayList;
import java.util.List;

import com.akjava.wiki.client.parser.ALinkStringParser;
import com.akjava.wiki.client.parser.AmazonCommandParser;
import com.akjava.wiki.client.parser.BoldStringParser;
import com.akjava.wiki.client.parser.BrCommandParser;
import com.akjava.wiki.client.parser.CodeCommandParser;
import com.akjava.wiki.client.parser.DirectAlinkParser;
import com.akjava.wiki.client.parser.EmptyLineParser;
import com.akjava.wiki.client.parser.IFrameParser;
import com.akjava.wiki.client.parser.IconCommandParser;
import com.akjava.wiki.client.parser.ImgStringParser;
import com.akjava.wiki.client.parser.ListCommandParser;
import com.akjava.wiki.client.parser.RefCommandParser;
import com.akjava.wiki.client.parser.SimpleCommandParser;
import com.akjava.wiki.client.parser.SplitCommandParser;
import com.akjava.wiki.client.parser.TagCommandParser;
import com.akjava.wiki.client.parser.TangoCommandParser;
import com.akjava.wiki.client.parser.TextCommandParser;
import com.akjava.wiki.client.parser.TopicParser;

/**
 * 
 *
 */
public class DefaultParsers {
public static List<LineParser> lineParsers=new ArrayList<LineParser>();
public static List<StringParser> stringParsers=new ArrayList<StringParser>();
static{
   
    lineParsers.add(new TopicParser());
    
    lineParsers.add(new EmptyLineParser());
    
    lineParsers.add(new CodeCommandParser());
    lineParsers.add(new TextCommandParser());
    
    lineParsers.add(new TangoCommandParser());
    
    
    //command
    lineParsers.add(new BrCommandParser());
    lineParsers.add(new AmazonCommandParser());
    lineParsers.add(new RefCommandParser());
    lineParsers.add(new IconCommandParser());
    lineParsers.add(new TagCommandParser());
    lineParsers.add(new IFrameParser());
    
 lineParsers.add(new ListCommandParser());
    
    lineParsers.add(new SplitCommandParser());

    lineParsers.add(new SimpleCommandParser());
    
    stringParsers.add(new ALinkStringParser());
    
    stringParsers.add(new BoldStringParser());
    stringParsers.add(new ImgStringParser());
    stringParsers.add(new DirectAlinkParser());
    //
}

    public static LineParser[] getLineParsers(){
        return (LineParser[])lineParsers.toArray(new LineParser[lineParsers.size()]);
    }
    
    public static StringParser[] getStringParsers(){
        return (StringParser[])stringParsers.toArray(new StringParser[stringParsers.size()]);
    }
}
