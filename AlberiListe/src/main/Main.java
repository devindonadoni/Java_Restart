package main;

import java.util.List;

import business.Biz;

public class Main {
	
	public Main() {
		
	}
	
	Biz biz = new Biz();
	
	public void execute(String filename) {
		List<String> list = new Util().readFile(filename);
		biz.addToTree(list);
	}
	
	public static void main(String[] args) {
		if(args.length != 0) {
			new Main().execute(args[0]);
		}else 
			System.out.println("file non trovato");
	}
}
