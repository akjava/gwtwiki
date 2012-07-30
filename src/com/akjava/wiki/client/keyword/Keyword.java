/*
 * Created on 2004/11/24
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.keyword;


/**
 * 
 *
 */
public class Keyword implements Comparable{
private String keyword;
private String url;
private String icon;
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
/**
 * @param string
 * @param string2
 */
public Keyword(String keyword, String url) {
    this.keyword=keyword;
    this.url=url;
}
public String getKeyword() {
    return keyword;
}
public void setKeyword(String keyword) {
    this.keyword = keyword;
}
public String getUrl() {
    return url;
}
public void setUrl(String url) {
    this.url = url;
}


public int compareTo(Object o) {
    if(o instanceof Keyword){
        return ((Keyword)o).getKeyword().compareTo(this.getKeyword());
    }
    return 0;
}

public boolean equals(Object o) {
	if(o instanceof Keyword){
		return this.toString().equals(o.toString());
	}
   return false;
  }

public boolean isRelative(){
	return url.startsWith("/");
}

public String toString() {
    return keyword+","+url;
  }
}
