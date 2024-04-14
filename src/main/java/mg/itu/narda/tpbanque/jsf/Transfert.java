/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.narda.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.itu.narda.tpbanque.entity.CompteBancaire;
import mg.itu.narda.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    private long idSource;
    private long idDestination;
    private int somme;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }

    public void setIdSource(long sourceId) {
        this.idSource = sourceId;
    }

    public long getIdSource() {
        return this.idSource;
    }

    public void setIdDestination(long destinationId) {
        this.idDestination = destinationId;
    }

    public long getIdDestination() {
        return this.idDestination;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public String transfert() {
        CompteBancaire source = this.gestionnaireCompte.findCompteById(idSource);
        CompteBancaire destination = this.gestionnaireCompte.findCompteById(idDestination);
        this.gestionnaireCompte.transferer(source, destination, this.somme);
        return "listeComptes?faces-redirect=true";
    }
}
