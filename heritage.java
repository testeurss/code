public class Etudiant
{
	public String nom;
	public String prenom;
	public Int age;
	public String niveau;
	public String filiere;

	public Etudiant(String nom, String prenom, Int age, String niveau, String filiere)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.niveau = niveau;
		this.filiere = filiere;
	}

	public void affiche ()
	{
		System.out.print("L'Etudiant" + this.nom + this.prenom);
		System.out.print("à la faculté" + this.filiere);
		System.out.println("en" + this.niveau);
	}

	public String getNom () {	return nom;	}
	
	public void setNom (String nom) { return nom; }
	
	public String getPrenom () { return prenom; }
	
	public void setPrenom (String prenom) { return prenom }

	public Int getAge () { return age; }

	public void setAge(Int age) { return age }

	public String getNiveau () { return niveau; }

	public void setNiveau (String niveau) { return niveau } 

	public String getFiliere () { return filiere; }

	public void setFiliere (String filiere) { return filiere }

	
}

class EtudiantEtranger extends Etudiant
{
	public String paysOrigine;

	public EtudiantEtranger (String nom, String prenom, Int age, String niveau, String filiere, String paysOrigine)
	{
		super(nom, prenom, age, niveau, filiere);
		this.paysOrigine = paysOrigine;
	}

	public void affiche ()
	{
		super.affiche();
		System.out.println("et mon pays d'origine est" + this.paysOrigine);

	}
}

class Classe 
{
	private final int maxEt;
    private static int nbEtudiants=0;
    private Etudiant[] listeEtudiant;
	//final int maxEtudiant 25;
	
	public Classe(int maxEt) 
	{
        if(maxET>0) listeEtudiant[nbEtudiants] = new Etudiant(maxEt);
        
    }

	void ajouterEtudiant(Etudiant e)
    {
        if (nbEtudiants < maxEt && nbEtudiants == 0) //Remplissage de la liste d'etudiants
        {
            listeEtudiant[nbEtudiants] = e;
            nbEtudiants++;
        } else { //Remplissage de la classe
            if (nbEtudiants != 0) {
                if (e.getFiliere().equals(listeEtudiant[0].getFiliere()) && e.getNiveau().equals(listeEtudiant[0].getNiveau()))
                {
                    listeEtudiant[nbEtudiants] = e;
                    nbEtudiants++;
                } else //Erreur d'ajout!
                    System.out.println("Impossible d'ajouter " + e.getPrenom() + " " + e.getNom() + " age de " + e
                            .getAge() +
                            " a la classe " + listeEtudiant[0].getFiliere() + ": Le niveau ou la filiere ne " +
                            "corresponde pas a la classe");
            } else
                System.out.println("Impossible d'ajouter " + e.getPrenom() + " " + e.getNom() + " age de " + e.getAge() +
                        " a la classe " + listeEtudiant[0].getFiliere() + ": classe pleine");
        }
    }

    public void afficherListe() 
    {
        System.out.println("\n Classe: "+this.listeEtudiant[0].getNiveau()+" "+this.listeEtudiant[0].getFiliere());
        for (int i = 0; i < nbEtudiants; i++) 
        {
            this.listeEtudiant[i].affiche();
            System.out.print("\n");
        }
    }

}