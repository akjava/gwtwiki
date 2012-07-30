/*
 * Created on 2005/03/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.akjava.wiki.client.core.DescriptionConverter;
import com.akjava.wiki.client.core.RootDocument;

/**
 * 
 *
 */
public class WikiTools {
	/*
    public static void main(String argv[]){
    
    String text;
    try {
        text = toDescription(IOUtils.toString(new FileReader(argv[0])));
        System.out.println(text);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    }
    public static String toDescription(File file) throws IOException{
        return toDescription(IOUtils.toString(new FileReader(file)));
      
        
    }
    
    
    public static String toDescription(String text){
        DocumentBuilder builder=new DocumentBuilder();
        RootDocument document=builder.createDocument(text);
        //log(document.toString());
        DescriptionConverter converter=new DescriptionConverter();
      
        
        return StringUtils.replace(converter.convert(document),",","&#44;");
        
    }
    */

}
