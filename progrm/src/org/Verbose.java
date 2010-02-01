package org;

import java.util.HashMap;

public class Verbose {

	private static final int MIN_ARGUMENT = 0;
	private static final int MAX_ARGUMENT = 6;

	private static int level = 1;
	public HashMap<String, String> option;

	public Verbose(String[] args){
		option = new HashMap<String, String>();
		if ((args.length > MAX_ARGUMENT) || (args.length < MIN_ARGUMENT)) {
			// boucle iterateur tant quela longueur de la chaine superieure a zero{

				// test argument.
			//}
		}
	}

	public static void print(String a,String b,String c){
		switch(level){
		case 1:
			System.out.println(a);
		case 2:
			System.out.println(b);
		case 3:
			System.out.println(c);
		}
	}

        // AFFICHAGE

    // GETTER

    // SETTER
}
