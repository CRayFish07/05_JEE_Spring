<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
				"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>人员列表</title>
</head>
<body>
	<s:form action="action_add" namespace="/person">
		name: <s:textfield name="person.name"/><br/>
		gender: <s:textfield name="person.gender"/><br/>
		<input type="submit" value="Submit"/>
	</s:form>
</body>
</html>