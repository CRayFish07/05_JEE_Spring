package com.joe.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.joe.service.IPersonService;

public class PersonAction extends Action {
	@Resource
	IPersonService personService;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
				HttpServletRequest request,HttpServletResponse response) throws Exception {
		/*
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
									this.getServlet().getServletContext());
		IPersonService personService = (IPersonService)ctx.getBean("personService");*/
		
		//retrieve all persons and set them to persons in request
		request.setAttribute("persons", personService.getAllPersons());
		return mapping.findForward("list");
	}
}
