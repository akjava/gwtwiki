/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;


import java.util.List;

import com.akjava.wiki.client.modules.LineFolder;
import com.akjava.wiki.client.modules.Text;
import com.akjava.wiki.client.util.StringUtils;

/**
 * 
 *
 */
public class StringLineDocumentBuilder {



	public static boolean debug;
	 public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean d) {
		debug = d;
	}

	/*
	public RootDocument createDocument(Path path,String texts) throws WikiException{
		  String lines[]=splitLine(texts,false);
		  RootDocument document=createDocument(lines,path!=null?path.getPath():"");
	      //document.addAttribute(path);
	       return document;
	 }
	 */
	
	 public static String[] splitLine(String text){
		text=StringUtils.replace(text,"\r\n", "\n");
		text=StringUtils.replace(text,"\r", "\n");
		return text.split("\n");
	 }
	/*
    public RootDocument createDocument(File file){
       
        String line=null;
        try {
            line = IOUtils.toString(new FileReader(file));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //String lines[]=line.split(SystemUtils.LINE_SEPARATOR);
        String lines[]=splitLine(line,false);
        
        RootDocument document=createDocument(lines);
        document.addAttribute(file.getAbsolutePath());
        return document;
    }
    */
    

    
	 /*
    public RootDocument createDocument(String text) throws WikiException{
        return createDocument(splitLine(text,false));
    }
    */
    public RootDocument createDocument(List<String> lines,String path) throws WikiException{
        return createDocument((String[])lines.toArray(new String[lines.size()]),path);
    }
    public static RootDocument createDocument(String[] lines,String path) throws WikiException{
    	if(debug){
    	System.out.println("[lineParsers]");
    	for(LineParser lineParser:DefaultParsers.lineParsers){
    		System.out.println(lineParser.getClass().getName());
    	}
    	System.out.println("[stringParsers]");
    	for(StringParser lineParser:DefaultParsers.stringParsers){
    		System.out.println(lineParser.getClass().getName());
    	}
    	}
    	
    	
        RootDocument document=new RootDocument();
        document.addAttribute(path);
        
        Element element=document;
        for(int i=0;i<lines.length;i++){
       // 	System.out.println(i+","+lines[i]);
           element=element.breakUp(element,lines[i]);
           LineParser[] parsers=element.getLineParses();
           
           boolean doParse=false;
           PARSER:for(int j=0;j<parsers.length;j++){
               if(parsers[j].canParse(lines[i])){
                   doParse=true;
                   element=parsers[j].parse(element,lines[i]);
                   if(debug){
                	   System.out.println(parsers[j].getClass().getName()+",parse "+lines[i]);
                   }
                   
                   break PARSER;
               }
           
           }
           
           if(!doParse){
               Element parent=element;
               element=new LineFolder();
               parent.addNode(element);
               
               String text="";
               String line=lines[i];
               StringParser[] stringParsers=element.getStringParsers();
               while(line.length()>0){
                boolean isMutch=false;
                for(int j=0;j<stringParsers.length;j++){
                    if(stringParsers[j].canParse(line)){
                        if(text.length()>0){
                            element.addNode(new Text(text));
                            text="";
                        	}
                        
                        isMutch=true;
                        line=stringParsers[j].parse(element,line);
                    }
                   
                }
                if(isMutch==false){
                    if(line.length()>0){
                    text+=line.charAt(0);
                    line=line.substring(1);
                    }
                }
              	//string parse;
              //System.out.println("string "+lines[i]);
          		}
               if(text.length()>0)
               element.addNode(new Text(text));
               
              // element.addNode(new LineSeparator());
               
               //return.
               element=parent;
           }
        }
    return document;  
    }
    
    public static Element replace(Element src,Element dest){
    	int size=src.countNode();
    	for(int i=0;i<size;i++){
    		Node el=src.getNodeAt(i);
    		
    		//TODO support set parent?
    		dest.addNode(el);
    	}
    	return dest;
    }

}
