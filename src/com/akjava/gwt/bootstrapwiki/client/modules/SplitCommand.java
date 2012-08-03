/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import java.util.ArrayList;
import java.util.List;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.ElementImp;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.RootDocument;
import com.akjava.wiki.client.core.StringLineDocumentBuilder;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.core.WikiException;
import com.akjava.wiki.client.modules.SimpleCommand;
import com.akjava.wiki.client.parser.LineContainerParser;

/**
 * 
 *
 */
public class SplitCommand extends ElementImp implements LineContainer{
    List<String> lines=new ArrayList<String>();
    public List<String> getLines() {
		return lines;
	}

	public SplitCommand(){
    setName("split");
    }

    /**
     * I'm not sure,but maybe never called.because on DocumentBuilder
        element=element.breakUp(element,lines[i]);
        LineParser[] parsers=element.getLineParses();
     */
    /*
    public LineParser[] getLineParses() {
        return new LineParser[]{TopicParser.getInstance(),TextCommandParser.getInstance(),CodeCommandParser.getInstance(),new PlainTextLineParser()};
    }
    */
    
    /**
     * use less?
     */
    
    public LineParser[] getLineParses() {
        // TODO Auto-generated method stub
        return new LineParser[]{new LineContainerParser(this)};
    }
    
    /**
     * usually not effect?
     * @return
     */
    public StringParser[] getStringParses() {
        // TODO Auto-generated method stub
        return new StringParser[]{};
    }
    
    
    public Element breakUp(Element element,String line){
    	
    	//TODO must find clear command like #clear
    	if(line.equals("#text") || line.startsWith("#split")){
    		return element.getParent();
    	}
    	
        return element;
    }

	@Override
	public void addLine(String line) {
		lines.add(line);
	}

	private void parse(List<String> tmpLines){
		 RootDocument root;
		try {
			root = StringLineDocumentBuilder.createDocument(tmpLines.toArray(new String[tmpLines.size()]),"");
			 StringLineDocumentBuilder.replace(root, this);
		} catch (WikiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void parseLines(Node node) {
		List<String> tmpLines=new ArrayList<String>();
		for(String line:lines){
			if(line.equals("#block")){
				parse(tmpLines);
				tmpLines=new ArrayList<String>();
				this.addNode(new SimpleCommand("block"));
			}else{
				tmpLines.add(line);
			}
		}
		
		if(tmpLines.size()>0){
			parse(tmpLines);
		}
	}
}
