import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class LectureDtrain {

    public static char[] alphabet={'A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W','Y','-'};
    protected final static int q=21;   /*nombre d acide amine = taille alphabet*/
    protected final static int M=5643; /*nombre de proteines*/
    protected final static int L=48;   /*longueur d une proteine*/
    public static ArrayList<ArrayList<Character>> matrice_colonne = new ArrayList<ArrayList<Character>>();
    public static ArrayList<ArrayList> matrice_ligne = new ArrayList<ArrayList>();
    public static ArrayList<String> seq = new ArrayList<String>(); /*sequence d acides amines lue en parametre*/

    public static void lecture_sequence(String fichier) throws IOException
    {
	BufferedReader in = new BufferedReader (new FileReader (new File(fichier)));
	
	while (in.readLine() != null)
	    {
		seq.add(in.readLine());
	    }
    }
    
    /*Rend la colonne i de la matrice*/
    public static ArrayList<Character> Colonne_i (int i)
    {
	ArrayList<Character> res = new ArrayList<Character>();
	
	for (int j=0; j<seq.size(); j++)
	    {
		res.add(seq.get(j).charAt(i));
	    }
	return res;
    }
    
    /*Rend la ligne i de la matrice*/
    public static ArrayList<Character> Ligne_i (int i)
    {
	ArrayList<Character> res = new ArrayList<Character>();
	
	for (int j=0; j<seq.get(i).length(); j++)
	    {
		res.add(seq.get(i).charAt(j));
	    }
	return res;
    }
    
    public static void remplissage_colonne_matrice()
    {
	for (int i=0; i<L; i++)
	    {
		matrice_colonne.add(Colonne_i(i));
	    }
    }
    
    public static void remplissage_ligne_matrice()
    {
	for (int i=0; i<M; i++)
	    {
		matrice_ligne.add(Ligne_i(i));
	    }
    }
    
    /*Lit le fichier et initialise la matrice*/
    public static void LectureDtrain(String fichier)
    {
	try {
	    lecture_sequence(fichier);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	remplissage_colonne_matrice();
	remplissage_ligne_matrice();
	System.out.println("Fin lecture : "+fichier);
    }
}
