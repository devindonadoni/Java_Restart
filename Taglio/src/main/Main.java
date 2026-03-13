package main;

import java.util.List;

import business.Biz;
import business.Config;

public class Main {
	public Main() {}
	
	Biz biz = new Biz();
	
	public void execute(String filename) {
		List<String> utilConfig = new Util().readFile(filename);
		Config config = new Config(utilConfig);
		//System.out.println(config.toString());
		
		List<String> utilOrdini = new Util().readFile(config.pathOrdini);
		biz.fetchOrders(utilOrdini);
		
		biz.printOrders();
	}
	
	public static void main(String[]args) {
		if(args != null)
			new Main().execute(args[0]);
		else
			System.out.println("File inesistente");
	}
}
