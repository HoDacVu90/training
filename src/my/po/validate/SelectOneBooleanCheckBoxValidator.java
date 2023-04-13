package my.po.validate;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;

import org.primefaces.util.MessageFactory;

@FacesValidator("selectOneBooleanCheckBoxValidator")
public class SelectOneBooleanCheckBoxValidator implements Validator
{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        if (o instanceof Boolean && o.equals(Boolean.FALSE)) {
            String       clientId = uiComponent.getClientId(facesContext);
            Object[] params = {clientId};
            String mess = MessageFactory.getMessage(UIInput.REQUIRED_MESSAGE_ID,params);
            FacesMessage message  = new FacesMessage(FacesMessage.SEVERITY_ERROR,"",mess);
            throw new ValidatorException(message);
        }
    }
}