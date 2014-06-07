import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static char[] alphabet= LectureDtrain.alphabet;
    protected final static int q=LectureDtrain.q;                                   /*nombre d acide amine = taille alphabet*/
    protected final static int M=LectureDtrain.M;                                   /*nombre de proteines*/
    protected final static int L=LectureDtrain.L;                                   /*longueur d une proteine*/
    
    public static ArrayList<String> seq = LectureDtrain.seq;   
    public static ArrayList<ArrayList> matrice_ligne = LectureTSeq.matrice_ligne;


    /*Test les occurences d un acide amine*/
    public static void TestOccurence()
    {
	for (int i=0; i<q; i++)
	    {
		System.out.println("\nNombre Occurences acide aminée : '"+alphabet[i]+"'");
		System.out.println("-------------------------------------");
		for (int j=0; j<L-1; j++)
		    {
			System.out.println("Acide aminée '"+alphabet[i]+"' en position "+j+" : "+Statistiques.nb_occ_aa_pos_i (alphabet[i],j));
		    }
	    }
    }
    
    /*Test le poids de chaque acide aminee*/
    public static void TestPoids()
    {
	for (int i=0; i<q; i++)
	    {
		System.out.println("\nPoids acide aminée : '"+alphabet[i]+"'");
		System.out.println("-------------------------");
		for (int j=0; j<L-1; j++)
		    {
			System.out.println("Acide aminée '"+alphabet[i]+"' en position "+j+" : "+Statistiques.Poids(alphabet[i],j));
		    }
	    }
    }

    /*Test l entropie*/
    public static void TestEntropie()
    {
	for (int i=0; i<L; i++)
	    {
		System.out.println("Entropie en position "+i+" : "+Statistiques.entropie(i));
	    }
	
	for (int i=0; i<3; i++)
	    {
		System.out.println("Position Max (indice : "+i+") : "+Statistiques.indicePositionConserve()[i]+" ,valeur : "+Statistiques.valPositionConserve()[i]);  
	    }
    }
    
    /*Test la frequence*/
    public static void TestFrequence()
    {
	double total = 0;
	for (int i=0; i<q; i++)
	    {
		System.out.println("\nFrequence acide aminée : '"+alphabet[i]+"' = " + Statistiques.f_0_b(alphabet[i]));	   
		System.out.println("-------------------------");
		//total += Statistiques.f_0_b(alphabet[i]);
		//System.out.println("\tModele nul : "+Statistiques.P0(alphabet[i]));
	    }
	
	System.out.println("total = " + total);
    }
    public static void TestVraisemblance()
    {
	double l;
	ArrayList seq;
	//	String s;
	for (int j=0; j<matrice_ligne.size();j++){
	    seq = matrice_ligne.get(j);
	    /*s = "";
	    for (int i=0; i<L; i++) {
		s+= seq.get(i);
		}*/

	l = Statistiques.vraisemblance(seq);
	System.out.println("Position "+ j + " : " + l);

	}
    }
    
    public static void TestInfoMutuelle()
    {
	Statistiques.information_mutuelle("infos.txt");
	//System.out.println("M(0,1) = " + Statistiques.M(0,1));
    }
    public static void TestFraction(){
	Statistiques.fraction("top50.txt", "fraction.txt");
    }
}
	
