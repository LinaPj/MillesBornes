package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

    private Carte[] cartes;
    private int nbCartes;
    private int modCount;

    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
        this.modCount = 0;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(Carte carte) {
        if (nbCartes == cartes.length) {
            throw new IllegalStateException("Sabot plein");
        }

        cartes[nbCartes] = carte;
        nbCartes++;
        modCount++;
    }

    @Override
    public Iterator<Carte> iterator() {

        return new Iterator<Carte>() {

            private int indice = 0;
            private int dernierRetourne = -1;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                verifierModification();
                return indice < nbCartes;
            }

            @Override
            public Carte next() {
                verifierModification();

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                Carte carte = cartes[indice];
                dernierRetourne = indice;
                indice++;

                return carte;
            }

            @Override
            public void remove() {
                verifierModification();

                if (dernierRetourne == -1) {
                    throw new IllegalStateException();
                }

                for (int i = dernierRetourne; i < nbCartes - 1; i++) {
                    cartes[i] = cartes[i + 1];
                }

                cartes[nbCartes - 1] = null;
                nbCartes--;
                indice--;

                dernierRetourne = -1;

                modCount++;
                expectedModCount++;
            }

            private void verifierModification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public Carte piocher() {
        Iterator<Carte> it = iterator();

        Carte carte = it.next();
        it.remove();

        return carte;
    }
}