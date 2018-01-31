package main;

import java.io.InputStreamReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import query.deparser.postgres.PgQueryRootDeparser;
import query.lang.QueryRoot;
import query.parser.ParseException;
import query.parser.json.JsonQueryRootParser;

public class Main {

	public static void main(String[] args) {
		JsonParser parser = new JsonParser();
		JsonElement json = parser.parse(new InputStreamReader(ClassLoader.getSystemResourceAsStream("query.json")));
		
		try {
			QueryRoot root = new JsonQueryRootParser().parse(json);
			String SQL = new PgQueryRootDeparser().deparse(root);
			
			System.out.println(SQL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
