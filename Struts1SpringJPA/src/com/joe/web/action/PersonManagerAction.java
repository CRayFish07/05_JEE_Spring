package com.joe.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.joe.bean.Person;
import com.joe.service.IPersonService;
import com.joe.web.formbean.PersonForm;

public class PersonManagerAction extends DispatchAction {
	@Resource
	IPersonService personService;
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonForm formBean = (PersonForm) form;
		personService.save(new Person(formBean.getName(),formBean.getGender()));
		request.setAttribute("message", "添加成功");
		return mapping.findForward("message");
	}

}
