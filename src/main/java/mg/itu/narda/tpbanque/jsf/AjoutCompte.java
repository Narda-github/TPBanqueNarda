/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.narda.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import mg.itu.narda.tpbanque.entity.CompteBancaire;
import mg.itu.narda.tpbanque.jsf.util.Util;
import mg.itu.narda.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    private String nom;

    @PositiveOrZero
    private int solde;
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public String action() {
        CompteBancaire nouveau = new CompteBancaire(this.nom, this.solde);
        gestionnaireCompte.creerCompte(nouveau);
        Util.addFlashInfoMessage("Compte  " + nouveau.getNom() + "  créé avec un solde de " + nouveau.getSolde());
        return "ajoutCompte?faces-redirect=true";
    }

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

}
