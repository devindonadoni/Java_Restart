package boundary;

import java.util.ArrayList;
import java.util.List;

import bean.Ordine;
import bean.Pezzo;
import business.Biz;
import business.Config;
import util.FileUtil;

public class Console {
	
	Biz biz = new Biz();	
	
	
	public void execute() {
		biz.populateList();
		//biz.printList();
		
		biz.printSummary();
		
	}

}
