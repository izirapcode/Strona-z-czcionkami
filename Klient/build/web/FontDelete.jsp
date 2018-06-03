<%-- 
    Document   : FontDelete
    Created on : 2018-02-19, 16:54:34
    Author     : JacekKiszonka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1>Czcionke</h1>
    <%-- start web service invocation --%><hr/>
    <a href="pokaz.jsp">Wroc</a>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	wbpack.CzcionkaWebService_Service service = new wbpack.CzcionkaWebService_Service();
	wbpack.CzcionkaWebService port = service.getCzcionkaWebServicePort();
	 // TODO initialize WS operation arguments here
	port.usunCzcionke(Integer.parseInt(request.getParameter("idfont")));
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
