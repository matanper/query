package main;

import java.io.InputStreamReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import query.exceptions.ParseException;
import query.json.JsonQueryRoot;
import query.lang.QueryRoot;

public class Main {

	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		JsonElement json = parser.parse(new InputStreamReader(ClassLoader.getSystemResourceAsStream("query.json")));
		
		try {
			QueryRoot root = new JsonQueryRoot(json);
			//String SQL = new PgQueryRootDeparser().deparse(root);
			
			System.out.println(root);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
