/*
 * Created on 2004/11/20
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import java.util.Vector;

import com.akjava.wiki.client.htmlconverter.AlinkConverter;
import com.akjava.wiki.client.htmlconverter.AmazonConverter;
import com.akjava.wiki.client.htmlconverter.BoldConverter;
import com.akjava.wiki.client.htmlconverter.CodeCommandConverter;
import com.akjava.wiki.client.htmlconverter.CreativeCommonsConverter;
import com.akjava.wiki.client.htmlconverter.DivConverter;
import com.akjava.wiki.client.htmlconverter.DownloadConverter;
import com.akjava.wiki.client.htmlconverter.IFrameConverter;
import com.akjava.wiki.client.htmlconverter.IconConverter;
import com.akjava.wiki.client.htmlconverter.ImgConverter;
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
import com.akjava.wiki.client.htmlconverter.TopicConverter;
import com.akjava.wiki.client.util.StringUtils;



/**
 * 
 *@deprecated dont use for create now
 */
public class DefaultHtmlDocumentConverter extends AbstractDocumentConverter{

	
    public DefaultHtmlDocumentConverter(){
        super();
        
    }
    private String amazonId; //for amazon 
    private String iconHost;
    private String startImage;
    private String imageHost;
    protected void initializeConverters(){
    	list=new Vector<NodeConverter>();
        list.add(new TopicConverter());
        AmazonConverter amazon=new AmazonConverter();
        if(amazonId!=null){
        	amazon.setUserId(amazonId);
        }
        list.add(amazon);
        list.add(new LineFolderConverter());
        list.add(new PlainTextConverter());
        list.add(new TextConverter());
        list.add(new LineSeparatorConverter());
        
        list.add(new TagCommandConverter());
        list.add(new AlinkConverter());
        list.add(new BoldConverter());
        list.add(new CodeCommandConverter());
        
        RefConverter ref=new RefConverter();
        if(startImage!=null && imageHost!=null){
        	ref.addBaseHost(new BaseHost(startImage,imageHost));
        }
        list.add(ref);
        IconConverter icon= new IconConverter();
        if(iconHost!=null){
        	icon.setIconHost(iconHost);
        }
        list.add(icon);
        list.add(new CreativeCommonsConverter());
        list.add(new PopupConverter());
        list.add(new DownloadConverter());
        list.add(new IFrameConverter());
        
        list.add(new ListCommandConverter());
        
        
        
        list.add(new SplitCommandConverter());
        list.add(new DivConverter());
        
        list.add(new ImgConverter());
        
        setNodeConverters((NodeConverter[]) list.toArray(new NodeConverter[list.size()]));
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
       html=StringUtils.replace(html,"${path}",toXucker(document.getDocumentPath()));
       return html;
    }
    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.AbstractConverter#getTail(org.jpn.xucker.wiki.Document)
     */
    public String getFooter(Document document) {
        String title=document.getDocumentTitle();
        String html=StringUtils.replace(footerText,"${title}",title);
        html=StringUtils.replace(html,"${path}",toXucker(document.getDocumentPath()));
        return html;
    }


    public String toXucker(String absolutePath){
        
        String base="C:\\Users\\aki\\Documents\\xucker\\xucker\\xdoc\\";
        if(!absolutePath.startsWith(base)){
            
            return absolutePath;
        }
        String ret=absolutePath.substring(base.length(),absolutePath.length()-".txt".length());
        ret=StringUtils.replace(ret,"\\","/");
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

	public String getAmazonId() {
		return amazonId;
	}

	public void setAmazonId(String amazonId) {
		this.amazonId = amazonId;
	}

	public String getIconHost() {
		return iconHost;
	}

	public void setIconHost(String iconHost) {
		this.iconHost = iconHost;
	}

	public String getStartImage() {
		return startImage;
	}

	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}

	public String getImageHost() {
		return imageHost;
	}

	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}
}
