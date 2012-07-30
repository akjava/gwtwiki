package com.akjava.wiki.client.modules;

import java.util.Arrays;
import java.util.List;

public class Commands {
	//ignore #block which is part of #split
private static List<String> commands=Arrays.asList("#text","#tag","#tango","#code","#split");

public static boolean isBreakUp(String line){
	if(line.startsWith("*")){
		return true;
	}
	
	for(String value:commands){
		if(line.startsWith(value)){
			return true;
		}
	}
	return false;
}

}
