<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"  %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>Music School Teacher Registration Page</title>
<style type="text/css">
.errorDiv{
	background-color:gray;
	border:1px solid black;
	width:400px;
	margin-bottom:8px;
}
</style>

</head>
<body>
<h2>Music School Teacher's Registration Page: </h2>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
	</div>
</s:if>
<s:if test="hasActionMessages()">
	<div class="errorDiv">
		<s:actionmessage/>
	</div>
</s:if>
<s:form action="teacherreg">
<s:textfield name="fname" label="First Name*"></s:textfield>
<s:textfield name="lname" label="Last Name*"></s:textfield>
<s:select label="What do you teach?*"
headerKey="-1" headerValue="Select"
list="#{'1':'Classical Music','2':'Light Music','3':'Instrumental Music'}"
name="musictype"
value="-1"></s:select>
<s:textfield name="yearsofexp" label="Your Teaching experience in years*"></s:textfield>
<s:textfield name="email" label="EmailId*"></s:textfield>
<s:textfield name="phonenumber" label="Mobile Number*"></s:textfield>
<s:textfield name="altnumber" label="Alternate Number"></s:textfield>
<s:submit></s:submit>
</s:form>

</body>

</html>
