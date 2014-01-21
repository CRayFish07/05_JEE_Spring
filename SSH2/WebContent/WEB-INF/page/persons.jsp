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
	<s:iterator value="persons">
		id=<s:property value="id"/>,name=<s:property value="name"/>,gender=<s:property value="gender"/><br/>
	</s:iterator>
</body>
</html>