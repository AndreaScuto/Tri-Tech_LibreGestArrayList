public class GestoreLibreria {

    private Media[] collezione;
    private int idMateriale;
    private final int maxElementi = 100;

    public GestoreLibreria() {
        this.collezione = new Media[maxElementi];
        this.idMateriale = 0;
    }

    public void aggiungiMateriale(Media m) {
        if (idMateriale < maxElementi) {
            m.setId(idMateriale);
            collezione[idMateriale++] = m;
            System.out.println("Materiale aggiunto con successo.");
        } else {
            System.out.println("Errore: Collezione piena!");
        }
    }

    public void rimuoviMaterialePerId(int id) {
        boolean trovato = false;
        for (int i = 0; i < idMateriale; i++) {
            if (collezione[i] != null && collezione[i].getId() == id) {
                for (int j = i; j < idMateriale - 1; j++) {
                    collezione[j] = collezione[j + 1];
                    collezione[j].setId(j);
                }
                collezione[idMateriale - 1] = null;
                idMateriale--;
                trovato = true;
                System.out.println("Materiale con ID " + id + " rimosso con successo.");
                break;
            }
        }
        if (!trovato) {
            System.out.println("Materiale con ID " + id + " non trovato.");
        }
    }

    // Verifica la disponibilità di un materiale e stampa la quantità disponibile
    public boolean verificaDisponibilita(int idElemento) {
        for (int i = 0; i < idMateriale; i++) {
            if (collezione[i].getId() == idElemento) {
                if (collezione[i] != null) {
                    if (collezione[i].eDisponibile()) {
                        // Stampa la disponibilità e la quantità
                        System.out.println("Il materiale con ID " + idElemento + " è disponibile.");
                        System.out.println("Quantità disponibile: " + ((Media)collezione[i]).getQuantita());
                        return true;
                    } else {
                        System.out.println("Il materiale con ID " + idElemento + " non è disponibile.");
                        return false;
                    }
                }
            }
        }
        System.out.println("Materiale con ID " + idElemento + " non trovato.");
        return false;
    }

    // Decrementa la quantità di stock automaticamente dopo la vendita
    public void decrementaStock(int idElemento) {
        for (int i = 0; i < idMateriale; i++) {
            if (collezione[i].getId() == idElemento) {
                if (collezione[i] != null && collezione[i].eDisponibile()) {
                    collezione[i].decrementaQuantita();  // Decrementa di 1 la quantità
                    System.out.println("Stock del materiale con ID " + idElemento + " decrementato.");
                } else {
                    System.out.println("Il materiale con ID " + idElemento + " non è disponibile.");
                }
                return;
            }
        }
        System.out.println("Materiale con ID " + idElemento + " non trovato.");
    }

    public ElementiBiblioteca[] cercaPerTitolo(String titolo) {
        ElementiBiblioteca[] risultati = new ElementiBiblioteca[idMateriale];
        int trovato = 0;

        for (int i = 0; i < idMateriale; i++) {
            if (collezione[i] != null && collezione[i].getTitolo().equalsIgnoreCase(titolo)) {
                risultati[trovato++] = collezione[i];
            }
        }
        ElementiBiblioteca[] risultatiEffettivi = new ElementiBiblioteca[trovato];
        System.arraycopy(risultati, 0, risultatiEffettivi, 0, trovato);
        return risultatiEffettivi;
    }

    public ElementiBiblioteca cercaPerId(int id) {
        for (int i = 0; i < idMateriale; i++) {
            if (collezione[i].getId() == id) {
                return collezione[i];
            }
        }
        return null;
    }

    public void stampaCollezione() {
        if (idMateriale == 0) {
            System.out.println("La collezione è vuota.");
        } else {
            System.out.println("Materiali nella collezione:");
            for (int i = 0; i < idMateriale; i++) {
                System.out.println(collezione[i].Descrivi());
            }
        }
    }

    public int contaTotale() {
        return idMateriale;
    }

    public int contaPerTipo(Class tipoElemento) {
        int conteggio = 0;
        for (int i = 0; i < idMateriale; i++) {
            if (collezione[i] != null && tipoElemento.isInstance(collezione[i])) {
                conteggio++;
            }
        }
        return conteggio;
    }
}
