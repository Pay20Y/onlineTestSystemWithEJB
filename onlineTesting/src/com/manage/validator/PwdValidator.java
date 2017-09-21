package com.manage.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.manage.validator.PwdValidator")
public class PwdValidator implements Validator{
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String password = (String)obj;
		if(password.length() < 8){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"密码长度小于8位","密码长度不得小于8");
			throw new ValidatorException(message);
		}
		String regx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(!password.matches(regx)){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"密码必须包括字符和数字","密码必须是字符加数字所组成");
			throw new ValidatorException(message);
		}
	}
}
