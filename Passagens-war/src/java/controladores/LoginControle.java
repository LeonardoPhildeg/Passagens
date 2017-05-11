/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelos.ClientesFacade;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Leonardo
 */
@Named(value = "loginControle")
@SessionScoped
public class LoginControle implements Serializable {

    @EJB
    private ClientesFacade clientesFacade;
    private String login;
    private String senha;

    public LoginControle() {
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String fazerLogin(){
        if(clientesFacade.loginControl(login, senha)){
        return "home.xhtml?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário e/ou Senha inválido!"));
        return"";
    }
    
    
    
}
