/*
 * Created on 2004/11/20
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client;

import java.util.Vector;

import com.akjava.gwt.bootstrapwiki.client.modules.AlertCommandParser;
import com.akjava.gwt.bootstrapwiki.client.modules.AlertConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.BLabelConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.BLabelStringParser;
import com.akjava.gwt.bootstrapwiki.client.modules.BtnConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.BtnStringParser;
import com.akjava.gwt.bootstrapwiki.client.modules.CodeConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.CodeStringParser;
import com.akjava.gwt.bootstrapwiki.client.modules.DivClassConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.DivCommandParser;
import com.akjava.gwt.bootstrapwiki.client.modules.IIconConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.IIconStringParser;
import com.akjava.gwt.bootstrapwiki.client.modules.SmallConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.SmallStringParser;
import com.akjava.gwt.bootstrapwiki.client.modules.TitleConverter;
import com.akjava.gwt.bootstrapwiki.client.modules.TopicToHeroConverter;
import com.akjava.wiki.client.core.AbstractDocumentConverter;
import com.akjava.wiki.client.core.DefaultParsers;
import com.akjava.wiki.client.core.Document;
import com.akjava.wiki.client.core.NodeConverter;
import com.akjava.wiki.client.htmlconverter.AlinkConverter;
import com.akjava.wiki.client.htmlconverter.AmazonConverter;
import com.akjava.wiki.client.htmlconverter.BoldConverter;
import com.akjava.wiki.client.htmlconverter.CodeCommandConverter;
import com.akjava.wiki.client.htmlconverter.CreativeCommonsConverter;
import com.akjava.wiki.client.htmlconverter.DownloadConverter;
import com.akjava.wiki.client.htmlconverter.IFrameConverter;
import com.akjava.wiki.client.htmlconverter.IconConverter;
import com.akjava.wiki.client.htmlconverter.LineFolderConverter;
import com.akjava.wiki.client.htmlconverter.LineSeparatorConverter;
import com.akjava.wiki.client.htmlconverter.ListCommandConverter;
import com.akjava.wiki.client.htmlconverter.PlainTextConverter;
import com.akjava.wiki.client.htmlconverter.PopupConverter;
import com.akjava.wiki.client.htmlconverter.RefConverter;
import com.akjava.wiki.client.htmlconverter.RefConverter.BaseHost;
import com.akjava.wiki.client.htmlconverter.SplitCommandConverter;
import com.akjava.wiki.client.htmlconverter.TagCommandConverter;
import com.akjava.wiki.client.htmlconverter.TextConverter;
import com.akjava.wiki.client.util.StringUtils;

/**
 * 
 *
 */
public class BootstrapHtmlDocumentConverter extends AbstractDocumentConverter{

	
	
    private String baseXdocPath;
    public BootstrapHtmlDocumentConverter(String path){
    	this();
    	baseXdocPath=path;
    }
    
    private static boolean initialized;
    
    /**
     * add DefaultParsers too
     */
    public BootstrapHtmlDocumentConverter(){
        super();
    	if(!initialized){
        	initializeParsers();
        	initialized=true;
        }
    }
    public void initializeParsers(){
    	DefaultParsers.lineParsers.add(0, new DivCommandParser());
        DefaultParsers.stringParsers.add(0, new IIconStringParser());
        DefaultParsers.stringParsers.add(0, new BLabelStringParser());
        DefaultParsers.lineParsers.add(0, new AlertCommandParser());
        DefaultParsers.stringParsers.add(0, new CodeStringParser());
        DefaultParsers.stringParsers.add(0, new SmallStringParser());
        DefaultParsers.stringParsers.add(0, new BtnStringParser());
    }
    
    
    protected void startAction(Document document) {
      parseCommand(document.getDocumentPath());
    }
    
    /**
     * @param documentPath
     */
    private void parseCommand(String documentPath) {
    
    }


    /**
     * @param result
     * @return
     */
    protected String finallyAction(String result) {
        // TODO Auto-generated method stub
        if(result.endsWith("<br>")){
            return result.substring(0,result.length()-"<br>".length());
        }
        return result;
    }
    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.AbstractConverter#getHead(org.jpn.xucker.wiki.Document)
     */
    private String headerText="<html><head><title>${title}</title></head><body>";
    private String footerText="</body></html>";
    public String getHeader(Document document) {
       String title=document.getDocumentTitle();
       String html=StringUtils.replace(headerText,"${title}",title);
       html=StringUtils.replace(html,"${title1}",toSmallTitle(title));
       if(baseXdocPath!=null){
    	   html=StringUtils.replace(html,"${path}",toXucker(document.getDocumentPath()));
       }
       return html;
    }
    
    private String toSmallTitle(String text){
    	String ret="";
    	int comma=text.indexOf(",");
    	if(comma!=-1){
    		String title=text.substring(0,comma);
    		String small=text.substring(comma+1);
    		ret=title+"<small>"+small+"</small>";
    	}else{
    		ret=text;
    	}
    	return ret;
    }
    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.AbstractConverter#getTail(org.jpn.xucker.wiki.Document)
     */
    public String getFooter(Document document) {
        String title=document.getDocumentTitle();
        String html=StringUtils.replace(footerText,"${title}",title);
        html=StringUtils.replace(html,"${title}",toSmallTitle(title));
        if(baseXdocPath!=null){
        	html=StringUtils.replace(html,"${path}",toXucker(document.getDocumentPath()));
        }
        return html;
    }


    
    public String toXucker(String absolutePath){
        
        
        if(!absolutePath.startsWith(baseXdocPath)){
            
            return absolutePath;
        }
        String ret;
        if(absolutePath.endsWith(".inc.html")){
        ret=absolutePath.substring(baseXdocPath.length(),absolutePath.length()-".inc.html".length());
        ret=StringUtils.replace(ret,"\\","/");
        }else{
        ret=absolutePath.substring(baseXdocPath.length(),absolutePath.length()-".txt".length());
        ret=StringUtils.replace(ret,"\\","/");	
        }
        return ret;
    }


    public String getFooterText() {
        return footerText;
    }
    public void setFooterText(String footerText) {
        this.footerText = footerText;
    }
    public String getHeaderText() {
        return headerText;
    }
    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }


    protected void addConverter(){

        list.add(new TopicToHeroConverter());
        AmazonConverter amazon= new AmazonConverter();
        list.add(amazon);
        amazon.setUserId("akishomepag-22");
        
        list.add(new LineFolderConverter());
        list.add(new PlainTextConverter());
        list.add(new TextConverter());
        //list.add(new DivTextConverter());
        list.add(new LineSeparatorConverter());
        
        list.add(new TagCommandConverter());
        list.add(new AlinkConverter());
        list.add(new BoldConverter());
        list.add(new CodeCommandConverter());
        
        RefConverter ref=new RefConverter();
        ref.addBaseHost(new BaseHost("/img2/", "http://www2.akjava.com"));
        ref.addBaseHost(new BaseHost("/img3/", "http://www3.akjava.com"));
        list.add(ref);
        
        IconConverter icon=new IconConverter();
        icon.setIconHost("http://www2.akjava.com");
        list.add(icon);
        list.add(new CreativeCommonsConverter());
        list.add(new PopupConverter());
        list.add(new DownloadConverter());
        list.add(new IFrameConverter());
        //list.add(new XSampaConverter());
        //list.add(new TangoCommandConverter()); xsampa TODO support future
        
        list.add(new ListCommandConverter());
        
        list.add(new SplitCommandConverter());
        list.add(new DivClassConverter());
        //list.add(new DivConverter());
       // list.add(new ImgConverter());
        list.add(0,new IIconConverter());
        list.add(0,new BLabelConverter());
        list.add(0,new AlertConverter());
        list.add(0,new CodeConverter());
        list.add(0,new TitleConverter());
        
        list.add(0,new SmallConverter());
        list.add(0,new BtnConverter());
    }
    
	@Override
	protected void initializeConverters() {
	
       list=new Vector();
        addConverter();
        /** Never insert here.BootstrapHtmlDocumentConverter calls so much.
         *     DefaultParsers.lineParsers.add(0, new DivCommandParser());
    			DefaultParsers.stringParsers.add(0, new IIconStringParser());
         */
        
        //System.out.println(list.size());
        setNodeConverters((NodeConverter[]) list.toArray(new NodeConverter[list.size()]));
	}
}
