/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.projetofinalweb.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.NoResultException;
import utfpr.projetofinalweb.dao.UsuarioDAO;

/**
 *
 * @author Samsung
 */
@FacesValidator("UsuarioValidator")
public class UsuarioValidator implements Validator {
    
    private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String email = (String) o;
        if (!email.matches(EMAIL_PATTERN)){
            throw new ValidatorException(new FacesMessage("O e-mail " + email + " é inválido"));
        }
        try{
            usuarioDAO.pesquisarPorEmail(email);
            throw new ValidatorException(new FacesMessage("O e-mail " + email + " já foi cadastrado"));
        }
        catch(NoResultException e){
            
        }
        
    }
}
