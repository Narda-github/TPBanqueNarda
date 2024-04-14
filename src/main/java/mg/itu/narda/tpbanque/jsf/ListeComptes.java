/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.narda.tpbanque.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.narda.tpbanque.entity.CompteBancaire;
import mg.itu.narda.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;
    private List<CompteBancaire> allComptes;
    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }
    public List<CompteBancaire> getAllComptes() {
        if (this.allComptes == null) {
            this.allComptes = gestionnaireCompte.getAllComptes();
        }
        System.out.print("LIGNE 1"+this.allComptes.get(0).getNom());
        return this.allComptes;
    }

    

}
