/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Clientes;
import entidades.Passagens;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leonardo
 */
@Stateless
public class PassagensFacade extends AbstractFacade<Passagens> {

    @PersistenceContext(unitName = "Passagens-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassagensFacade() {
        super(Passagens.class);
    }
    
    
    public void reservarPassagemParaCliente(Passagens passagem, Clientes cliente) {
        passagem.setFkidCliente(cliente);
        System.out.println("ENTROU AQUI");
        // Definir na passagem existe que ela está reservada
        passagem.setDisponibilidadade(0);
        this.em.merge(passagem);
    }
        
        
    
    public void cancelarReservaDoCliente(Passagens passagem, Clientes cliente){
        passagem.setFkidCliente(null);
        passagem.setDisponibilidadade(1);
        this.em.merge(passagem);
    }
}
