package cartes;

public class JeuDeCartes {

    private Configuration[] typesDeCartes = {
        new Configuration(new Borne(25), 10),
        new Configuration(new Borne(50), 10),
        new Configuration(new Borne(75), 10),
        new Configuration(new Borne(100), 12),
        new Configuration(new Borne(200), 4),

        new Configuration(new Parade(Type.FEU), 14),
        new Configuration(new FinLimite(), 6),
        new Configuration(new Parade(Type.ESSENCE), 6),
        new Configuration(new Parade(Type.CREVAISON), 6),
        new Configuration(new Parade(Type.ACCIDENT), 6),

        new Configuration(new Attaque(Type.FEU), 5),
        new Configuration(new DebutLimite(), 4),
        new Configuration(new Attaque(Type.ESSENCE), 3),
        new Configuration(new Attaque(Type.CREVAISON), 3),
        new Configuration(new Attaque(Type.ACCIDENT), 3),

        new Configuration(new Botte(Type.FEU), 1),
        new Configuration(new Botte(Type.ESSENCE), 1),
        new Configuration(new Botte(Type.CREVAISON), 1),
        new Configuration(new Botte(Type.ACCIDENT), 1)
    };

    public String affichageJeuCartes() {
        StringBuilder resultat = new StringBuilder();

        for (Configuration config : typesDeCartes) {
            resultat.append(config.getNbExemplaires())
                    .append(" ")
                    .append(config.getCarte())
                    .append("\n");
        }

        return resultat.toString();
    }
    
    public String affichageJeuDeCartes() {
        return affichageJeuCartes();
    }

    public Carte[] donnerCartes() {
        int total = 0;

        for (Configuration config : typesDeCartes) {
            total += config.getNbExemplaires();
        }

        Carte[] cartes = new Carte[total];
        int indice = 0;

        for (Configuration config : typesDeCartes) {

            for (int i = 0; i < config.getNbExemplaires(); i++) {
                cartes[indice] = config.getCarte();
                indice++;
            }
        }

        return cartes;
    }

    public boolean checkCount() {

        Carte[] cartes = donnerCartes();

        for (Configuration config : typesDeCartes) {

            int compteur = 0;

            for (Carte carte : cartes) {
                if (config.getCarte().equals(carte)) {
                    compteur++;
                }
            }

            if (compteur != config.getNbExemplaires()) {
                return false;
            }
        }

        return true;
    }
}