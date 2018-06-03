<%-- 
    Document   : show
    Created on : 2018-02-19, 17:18:20
    Author     : JacekKiszonka
--%>

<%@page import="org.apache.commons.io.FileUtils"%>
<%@page import="java.io.File"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="czcionka.Czcionka"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%
    Vector <Czcionka> czcionki=null;
    try {
	wbpack.CzcionkaWebService_Service service = new wbpack.CzcionkaWebService_Service();
	wbpack.CzcionkaWebService port = service.getCzcionkaWebServicePort();
	// TODO process result here
	byte[] result = port.dajCzcionki();
            ByteArrayInputStream bais;
            ObjectInputStream ins;
            bais = new ByteArrayInputStream(result);
            ins = new ObjectInputStream(bais);
            czcionki = (Vector <Czcionka>) ins.readObject();
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
                Czcionka taCzcionka=null;
                for(Czcionka czcionka:czcionki)
                    if(czcionka.getId()==Integer.parseInt(request.getParameter("idfont")))
                        taCzcionka=czcionka;
                File f = new File("C:\\Users/JacekKiszonka/Documents/NetBeansProjects/WelencKlient/web/czcionka.ttf");
                FileUtils.writeByteArrayToFile(f,taCzcionka.getCzcionka());
    %>
	<style type="text/css">
@font-face {
    font-family: "My Custom Font";
    src: url(czcionka.ttf);
}
p.customfont { 
    font-family: "My Custom Font";
}
</style>
<title>Page Title</title>
</head>
<body>

<p class="customfont">This your font!</p>


    <%-- start web service invocation --%><hr/>

    <%-- end web service invocation --%><hr/>
</body>
</html>