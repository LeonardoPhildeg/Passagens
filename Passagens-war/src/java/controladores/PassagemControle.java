/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Passagens;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelos.PassagensFacade;

/**
 *
 * @author Leonardo
 */
@Named(value = "passagemControle")
@SessionScoped
public class PassagemControle implements Serializable {

 
    @EJB
    private PassagensFacade passagemFacade;
    private Passagens passagem = new Passagens();
    
    public PassagemControle() {
    }

    public Passagens getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagens passagem) {
        this.passagem = passagem;
    }
    
    public List <Passagens> getListaPassagens(){
        return this.passagemFacade.findAll();
    }
    
    public void delete(Passagens passagem){
        this.passagemFacade.remove(passagem);
    }
}
