import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class Statistiques {
    public static char[] alphabet= LectureDtrain.alphabet;
    protected final static int M = LectureDtrain.M;
    protected final static int L = LectureDtrain.L;
    protected final static int q = LectureDtrain.q;
    public static ArrayList<ArrayList<Character>> matrice_colonne = LectureDtrain.matrice_colonne;
    public static ArrayList matrice_ligne = LectureTSeq.matrice_ligne;

    /*nombre occurrence acide aminee en position i*/
    public static int nb_occ_aa_pos_i (char c, int pos)
    {
	int occ = 0;
	ArrayList mat = (ArrayList) matrice_colonne.get(pos);
	
	for (int i=0; i<M; i++)
	    {
		if ( (char) (mat.get(i)) == c)
		    occ++;
	    }
	return occ;
    }

    /*Rends le poids*/
    public static double Poids(char c, int i)
    {
	return (double) (nb_occ_aa_pos_i(c,i)+1)/(M+q);
    }


    /*Rends l entropie de la position i*/
    public static double entropie (int colonnei)
    {
	double res=0;
	for (int i=0; i<q; i++)
	    {
		res = res + (Poids(alphabet[i],colonnei) * (Math.log(Poids(alphabet[i],colonnei)))/Math.log(2));
	    }
	return res + (Math.log(q)/Math.log(2));
    }

    
    /*Rends un tableau qui contient les trois positions les plus conservees*/
    public static int[] indicePositionConserve ()
    {
	double max1=-1;
	double max2=-1;
	double max3=-1;
	int positionMAX1=0;
	int positionMAX2=0;
	int positionMAX3=0;
	int[] indiceMAX1_2_3 = new int[3];
	double[] sj = new double[L];
	
	/*stockage des entropie dans un tableau sj*/
	for (int i=0; i<L; i++)
	    {
		sj[i] = entropie(i);
	    }

	/*Calcul de la valeur max1*/
	for (int i=0; i<sj.length; i++)
	    {
		if (sj[i] > max1)
		    {
			max1=sj[i];
			positionMAX1=i;
		    }
	    }
	
	/*Calcul de la valeur max2*/
	for (int i=0; i<sj.length; i++)
	    {
		if (sj[i] > max2 && sj[i]< max1)
		    {
			max2=sj[i];
			positionMAX2=i;
		    }
	    }

	/*Calcul de la valeur max1*/
	for (int i=0; i<sj.length; i++)
	    {
		if (sj[i] > max3 && sj[i] < max2 && sj[i] < max1)
		    {
			max3=sj[i];
			positionMAX3=i;
		    }
	    }
	indiceMAX1_2_3[0] = positionMAX1;
	indiceMAX1_2_3[1] = positionMAX2;
	indiceMAX1_2_3[2] = positionMAX3;
	
	return indiceMAX1_2_3;
    }

    /*Rends un tableau qui contient les valeurs des trois positions les plus conservees*/
    public static double[] valPositionConserve ()
    {
	double max1=-1;
	double max2=-1;
	double max3=-1;
	double[] MAX1_2_3 = new double[3];
	double[] sj = new double[L];
	
	/*stockage des entropie dans un tableau sj*/
	for (int i=0; i<L; i++)
	    {
		sj[i] = entropie(i);
	    }

	/*Calcul de la valeur max1*/
	for (int i=0; i<sj.length; i++)
	    {
		if (sj[i] > max1)
		    {
			max1=sj[i];
		    }
	    }
	
	/*Calcul de la valeur max2*/
	for (int i=0; i<sj.length; i++)
	    {
		if (sj[i] > max2 && sj[i]< max1)
		    {
			max2=sj[i];
		    }
	    }

	/*Calcul de la valeur max1*/
	for (int i=0; i<sj.length; i++)
	    {
		if (sj[i] > max3 && sj[i] < max2 && sj[i] < max1)
		    {
			max3=sj[i];
		    }
	    }
	MAX1_2_3[0] = max1;
	MAX1_2_3[1] = max2;
	MAX1_2_3[2] = max3;
	
	return MAX1_2_3;
    }

    /*Equation 8 : Rend la frequence de chaque acide amine dans l alignement Dtrain entier*/
    public static double f_0_b (char c)
    {
	double somme=0;
		
	/*Somme des poids*/
	for (int i=0; i<L; i++)
	    {
		somme=somme+Poids(c,i);
	    }
	
	return (somme/L);
    }
    
    /* Equation 7 : probabilite d'une sequencec dans le modele nul*/
    public static double P0 (ArrayList seq)
    {
	double F0=0;
	double p=1;
	
	for (int i=0; i<L; i++)
	    {
		F0 = f_0_b((char)seq.get(i));
		p = (double) (p*F0);

	    }
	return p;
    }
    
    /* Equation 6 : probabilite d'une sequence dans le modele PSWM */

    public static double P(ArrayList seq){
	double p=1;
	for (int i=0; i<L; i++) {
	    p = p*Poids((char)seq.get(i), i);
	}
	return p;
    }

    public static double vraisemblance(ArrayList seq){
	return Math.log(P(seq)/P0(seq)) / Math.log(2);
    }


    public static double nb_occ_i_j(char a, int i, char b, int j){
	
	ArrayList<Character> col_i = matrice_colonne.get(i);
	ArrayList<Character> col_j = matrice_colonne.get(j); 
	//	for (int k=0; k<col_i.size(); k++) System.out.println(col_i.get(k) + " " + col_j.get(k)); 

	//	for (char c : col_j) System.out.print(c); 
        //System.out.print("\n");

	double cpt=0;
	for (int k=0; k<col_i.size(); k++){
	    if (col_i.get(k) == a && col_j.get(k) == b) cpt++; 
	}	
	return cpt; 
    }

    public static double poids(char a, int i, char b, int j) {
	return ((nb_occ_i_j(a, i, b, j) +  ((double)1.0/q)) / (double)(M+q));
    }

    public static double M (int i, int j){
	System.out.println("Appel a M");
	
	double somme = 0;
	char a, b;
	double p;
	
	for (int k=0; k<q; k++){
	    a = alphabet[k];
	    for (int l=0; l<q; l++){
		b = alphabet[l];
		p = poids(a,i,b,j);
		somme += p * (Math.log(p/(Poids(a,i)*Poids(b,j)))/Math.log(2));
	    }
	}
	return somme; 
    }
  
    public static void information_mutuelle(String fichier){
	try {
	    File file = new File(fichier); 
	    BufferedWriter output = new BufferedWriter(new FileWriter(file));
	    for (int i=0; i<L; i++){
		for (int j=i+1; j<L; j++)
		    output.write(i + " " + j + " " + M(i, j) + "\n");
	    }
	    output.close();
	} catch (IOException e){
	    e.printStackTrace();
	}
    }

    public static void fraction(String in, String out){
	double[][] dist = new double [L] [L];
	ArrayList pos_i = new ArrayList();
	ArrayList pos_j = new ArrayList();
	double compteur = 0;
	double total = 0;

	Scanner sc = null;
	try {
	    sc = new Scanner(new File("distances.txt"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();  
	}
	while (sc.hasNextLine()) {
	    Scanner sc2 = new Scanner(sc.nextLine());
	    int pos1 = Integer.parseInt(sc2.next());
	    int pos2 = Integer.parseInt(sc2.next());
	    dist[pos1][pos2]=Double.parseDouble(sc2.next());
        } 

	try {
	    sc = new Scanner(new File(in));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();  
	}
	try { 
	    File file = new File(out); 
	    BufferedWriter output = new BufferedWriter(new FileWriter(file));
	    output.write("#nbPaire fraction\n");
	    while (sc.hasNextLine()) {
		Scanner sc2 = new Scanner(sc.nextLine());
		int pos1 = Integer.parseInt(sc2.next());
		int pos2 = Integer.parseInt(sc2.next());
		if ( dist[pos1][pos2]<8) {compteur++;}
		total++;
		//output.write(pos1 + " " + pos2 + "\n");
		output.write(total + " " + (compteur/total)*100 + "\n");
		    
	    }
	    output.close();
	}catch (IOException e){
	    e.printStackTrace();
	}
    }
}
