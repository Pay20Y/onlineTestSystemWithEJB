package com.manage.validator;

import java.sql.*;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
import com.database.jdbc.Database;

@FacesValidator("com.manage.validator.LoginValidator")
public class LoginValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		// TODO Auto-generated method stub
		try {
		String userName = (String)obj;
		Database DB = new Database();
		Connection conn = DB.getConn();
		String sql = "select * from users where username="+userName;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSetQ(stmt, sql);
		
			if(!rs.next()){
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"用户不存在","用户压根不存在");
				throw new ValidatorException(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
