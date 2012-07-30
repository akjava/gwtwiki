/*
 * Created on 2011/09/15
 * Author aki@akjava.com
 * License Apache2.0
 */
package com.akjava.wiki.client.htmlconverter;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Img;
import com.akjava.wiki.client.parser.ImgStringParser;

/**
 * 
 *
 */
public class ImgConverter extends AbstractConverter{

public boolean canConvert(Node node){
    return (node instanceof Img);
	}
public String toHeader(Node node){
    return ImgStringParser.toText(node);
	}

public String toFooter(Node node){
    //currently not support.
    return "";
}

}
