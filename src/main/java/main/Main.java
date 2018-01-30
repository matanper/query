package main;

import java.io.InputStreamReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import query.lang.QueryRoot;
import query.lang.components.ParseException;
import query.parser.json.JsonQueryRootParser;

public class Main {

	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		JsonElement json = parser.parse(new InputStreamReader(ClassLoader.getSystemResourceAsStream("query.json")));
		
		try {
			QueryRoot root = (QueryRoot) QueryRoot.parse(new JsonQueryRootParser(), json);
			System.out.println(root);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
