/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.narda.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.itu.narda.tpbanque.entity.CompteBancaire;
import mg.itu.narda.tpbanque.jsf.util.Util;
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
        boolean erreur = false;
        CompteBancaire source = this.gestionnaireCompte.findCompteById(idSource);
        CompteBancaire destination = this.gestionnaireCompte.findCompteById(idDestination);
        if (source == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            erreur = true;
        } else {
            if (source.getSolde() < somme) { // à compléter pour le cas où le solde du compte source est insuffisant...
                Util.messageErreur("Solde du compte insuffisant!", "Solde insuffisant!", "form:somme");
                erreur = true;
            }
        }
        if (destination == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            erreur = true;
        }
        if (erreur) {
            return null;
        }
        this.gestionnaireCompte.transferer(source, destination, this.somme);
        Util.addFlashInfoMessage("Montant de  " + this.somme + "  transféré .Source: " + source.getNom() + "/Destinataire:" + destination.getNom());
        Util.addFlashInfoMessage("Transfert correctement effectué");
        return "listeComptes?faces-redirect=true";
    }

}
