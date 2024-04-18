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
import mg.itu.narda.tpbanque.entity.OperationBancaire;
import mg.itu.narda.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable {

    private Long compteId;
    private CompteBancaire compte;
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of Operation
     */
    public Operations() {
    }

    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long compteId) {
        this.compteId = compteId;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void loadCompte() {
        this.compte = gestionnaireCompte.findCompteById(this.compteId);
    }

    public List<OperationBancaire> getListeOperations() {
        return this.compte.getOperations();
    }
}
