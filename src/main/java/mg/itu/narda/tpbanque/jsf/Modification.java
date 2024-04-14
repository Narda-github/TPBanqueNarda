/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.narda.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.itu.narda.tpbanque.entity.CompteBancaire;
import mg.itu.narda.tpbanque.jsf.util.Util;
import mg.itu.narda.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@Named(value = "modification")
@ViewScoped
public class Modification implements Serializable {

    private long id;
    private String ancienNom;
    private CompteBancaire compte;
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of Modification
     */
    public Modification() {
    }

    public void loadCompte() {

        this.compte = gestionnaireCompte.findCompteById(id);
        this.ancienNom = this.compte.getNom();
    }

    public String enregistrerModification() {
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Modifications enregistrées, compte: " + id + ",ancien Nom : " + this.ancienNom + " Nouveau Nom: " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAncienNom() {
        return ancienNom;
    }

    public void setAncienNom(String ancienNom) {
        this.ancienNom = ancienNom;
    }

}
