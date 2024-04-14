/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.narda.tpbanque.config;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import mg.itu.narda.tpbanque.entity.CompteBancaire;
import mg.itu.narda.tpbanque.service.GestionnaireCompte;

/**
 *
 * @author Narda <mg.itu.narda>
 */
@ApplicationScoped
public class Init {
    @Inject
    private GestionnaireCompte gcompte;

    public void init(
        @Observes
        @Initialized(ApplicationScoped.class) ServletContext context) {
        creerCompte();
    }
    void creerCompte(){
        Long count = gcompte.nbComptes();
        if (count == 0) {
            gcompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gcompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gcompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gcompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
    
}
 