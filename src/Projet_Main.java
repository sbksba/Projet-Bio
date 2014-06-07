import java.util.Scanner;
import java.lang.*;

public class Projet_Main {
    public static void main (String[] args)
    {
	LectureDtrain.LectureDtrain("Dtrain.txt");
	LectureTSeq.LectureTSeq("test_seq.txt");
	
	Scanner sc = new Scanner(System.in);
	char choix;

	do{
	    System.out.println(" =======================");
	    System.out.println(" PROJET BIOINFORMATIQUE ");
	    System.out.println(" =======================\n");
	    System.out.println("-1- Test d'occurence");
	    System.out.println("-2- Test de poids");
	    System.out.println("-3- Test d'entropie");
	    System.out.println("-4- Test de fréquence");
	    System.out.println("-5- Test de vraisemblance");
	    System.out.println("-6- Test d'info mutuelle");
	    System.out.println("-7- Test de fraction");
	    System.out.println("-8- Quitter\n");
	    choix = sc.nextLine().charAt(0);
	    
	    switch(choix)
		{
		case '1':
		    System.out.println("\n TEST OCCURENCE");
		    System.out.println("-----------------");
		    Test.TestOccurence();
		    break;
		case '2':
		    System.out.println("\n TEST POIDS");
		    System.out.println("-------------");
		    Test.TestPoids();
		    break;
		case '3':
		    System.out.println("\n TEST ENTROPIE");
		    System.out.println("----------------");
		    Test.TestEntropie();
		    break;
		case '4':
		    System.out.println("\n TEST FREQUENCE");
		    System.out.println("----------------");
		    Test.TestFrequence();
		    break;
		case '5':
		    System.out.println("\n TEST VRAISEMBLANCE");
		    System.out.println("----------------");
		    Test.TestVraisemblance();
		    break;
		case '6':
		    System.out.println("\n TEST INFO MUTUELLE");
		    System.out.println("----------------");
		    Test.TestInfoMutuelle();
		    break;
		case '7':
		    System.out.println("\n TEST FRACTION");
		    System.out.println("----------------");
		    Test.TestFraction();
		    break;
		case '8':
		    break;
		default:
		    System.out.println("Commande inconnue");
		    break;
		}
	}while (choix != '8');
    }
}
