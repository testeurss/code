
<!DOCTYPE html>
	<html lang="fr">
		<meta charset="utf-8">
		<head>
			<title>Utilisateur</title>
		</head>
		<center>
		<body style="border:2px solid pink">
		<h1>Page pour la création des tilisateurs</h1>

			<form method="POST" action="creerUsers.php">

				<input type="text" name="log" placeholder="saisissez votre Login" required="required"/>
				<select name="profils">
                    <option value="user">User</option>
                    <option value="admin">Administrateur<option>
                </select>

				<input type="submit" value="Créer" name="submit"/>
			</form>

            <?php
//fonction pour générer des mots de pass aléatoir
                function genererMotDepass($numDeCaractere){
                    $motDepasse = "";
                    $tabDeCaracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    for($i=0; $i<$numDeCaractere; $i++){
//Onaléatoirement  prend aléatoirement un caractére sur la longue chaine tabDeCaracteres 
                        $caractere = rand(0, strlen($tabDeCaracteres)-1); 
//On concaténe les chaines de caractéres pour obtenir notre mot de passe de 10 chaines 
                        $motDepasse .= $tabDeCaracteres[$caractere];
                    }
//la fonction renvoie le mot de passe généré
                return $motDepasse;
                }
                
//Fonction pour ajouter les utilisateurs
extract($_POST);
$Password = genererMotDepass(10);
//_GLOBAL

                function ajouterUsers($log, $profils, $Password){
                    $monFichier = fopen('UsersProfils.txt','a+');
                    fputs($monFichier,$log.";".$profils.";".$Password."\n");
                    //fputs($monFichier,"--------------------------------------------------------------------\n");
                    fclose($monFichier);
                    }

//Fonction permettant de vérifier l'existance d'un utilisateur               
                function verifierUser(){
                    extract($_POST);
                    $exist=false;
                    $fichier = fopen("UsersProfils.txt","a+");
//Recupération des differentes lignes enregistrées
                while(!feof($fichier)){
                        $ligne = fgets($fichier);
                        $loggin = explode(";",$ligne);
//Verifier si l'utilisateur existe ou pas
                    if($loggin[0] == $log){
                        $exist = true;
                    }
                }
                    return $exist;
            }
                
//fonction permettant la recherche d'un utilisateur dans le fichierchier
//$fichier = ajouterUsers($log, $profils, $Password);
                    if(isset($submit)){
                        $a = verifierUser();
                        if($a == true){
                            echo("l'uilisateur existe dejà");
                            echo("<a href='creerUsers.php'>Saisir un autre loggin</a>");
                        }else{
                            ajouterUsers($log, $profils, $Password);
                        } 
                    }
                
                
            ?>
		
		</body>
		</center>
	</html>