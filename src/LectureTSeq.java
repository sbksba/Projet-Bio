import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LectureTSeq {
    protected final static int L=48;
    protected final static int M=5643;
    protected final static int q=21;

    public static String seq;
    public static char[] alphabet={'A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W','Y','-'};
    public static ArrayList<ArrayList> matrice_ligne=new ArrayList<>();
    

    /*lit le fichier et initialise la matrice */
    public static void LectureTSeq (String fichier)
    {
	try {
	    lecture_sequence(fichier);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	
	matrice_ligne();
	System.out.println("Fin lecture : "+fichier);
    }

    /* lit la ligne du ficher de test */
    public static void lecture_sequence(String fichier) throws IOException{	
	BufferedReader in=new BufferedReader(new FileReader(new File(fichier)));

	if ((in.readLine()!=null)){
	    seq = in.readLine(); 
	}
    }

    /* remplit la matrice avec toutes les sous sequences de taille L de la sequence a tester */
    public static void matrice_ligne(){
	for(int i=0;i<=(seq.length()-L);i++)
	    matrice_ligne.add(sequence_i(i));
    }

    /* recupere la sous sequence de taille L qui commence en position i */
    public static ArrayList sequence_i (int i){
	ArrayList res=new ArrayList();
	for(int k=i;k<(i+L);k++){
	    res.add(seq.charAt(k));
	    
	}
	return res;
    }
}
