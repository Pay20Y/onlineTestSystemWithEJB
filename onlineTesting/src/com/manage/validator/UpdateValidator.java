package com.manage.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.manage.validator.UpdateValidator")
public class UpdateValidator implements Validator {
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String password = (String)obj;
		System.out.println("----"+password);
		if(!password.equals("")){
		if(password.length() < 8){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"���볤��С��8λ","���볤�Ȳ���С��8");
			throw new ValidatorException(message);
		}
		String regx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		//if(!password.matches(".+[0-9]+") || !password.matches(".+[A-z]+")){
		if(!password.matches(regx)){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"�����������ַ�������","����������ַ������������");
			throw new ValidatorException(message);
		}
		}
	}
}
