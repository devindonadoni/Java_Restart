package main;

import java.util.List;
import java.util.Scanner;

import business.Biz;

public class Main {
	
	public Main() {
		
	}
	
	Biz biz = new Biz();
	Scanner s = new Scanner(System.in);
	
	public void execute(String filename) {
		List<String> list = new Util().readFile(filename);
		
		int n = 1;
		while(n != 0) {
			System.out.println("\n--------------------------------------");
			System.out.println("1. Visualizza dati raw file");
			System.out.println("2. Creazione albero per provincia");
			System.out.println("3. Stampa albero ordine alfabetico");
			System.out.println("4. Ricerca province per abitanti");
			System.out.println("5. Elenco province di regione");
			System.out.println("6. Ricerca per città principale");
			System.out.println("0. Esci dal programma");
			System.out.println("--------------------------------------\n");
			
			n = Integer.parseInt(s.nextLine());			
			switch(n) {
			
			case 0:
				System.out.println("GRAZIE CIAO");
				System.exit(0);
				break;
			case 1:
				for(String item : list)
					System.out.println(item);
				break;
			case 2:
				System.out.println(biz.addToTree(list) ? "SUCCESS" : "!ERROR!");
				break;
			case 3:
				biz.printTree();
				break;
			case 4:
				System.out.println("INSERISCI ABITANTI MINIMI -->");
				int min = Integer.parseInt(s.nextLine());
				System.out.println("INSERISCI ABITANTI MASSIMI -->");
				int max = Integer.parseInt(s.nextLine());
				biz.reserchAbitanti(min, max);
				
				biz.printList();
				break;
			case 5:
				System.out.println("INSERISCI REGIONE-->");
				String regione = s.nextLine();
				
				biz.reserchProvince(regione);
				
				biz.printListCity();
				break;
			case 6:
				System.out.println("INSERISCI CITTA-->");
				String citta = s.nextLine();
				System.out.println("INSERISCI SIGLA-->");
				String sigla = s.nextLine();
				
				biz.reserchPrincipale(citta, sigla);
				
				biz.printList();
				break;
			default:
				System.out.println("Nessun'azione");
				break;

			}
		}
		
		s.close();
	}
	
	public static void main(String[] args) {
		if(args.length != 0) {
			new Main().execute(args[0]);
		}else 
			System.out.println("file non trovato");
	}
}
