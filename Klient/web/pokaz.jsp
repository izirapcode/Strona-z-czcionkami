<%-- 
    Document   : pokaz
    Created on : 2018-02-19, 16:45:59
    Author     : JacekKiszonka
--%>

<%@page import="czcionka.Czcionka"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
    %>
    <br/> -----------------------------------------------<br/>
     <h1>Add font!</h1>
      Select a font to upload: <br />
       <form action="JspFont.jsp" method="post" enctype="multipart/form-data">      
      <input type="file" name="file" size="50" />
      <br />
      <input type="text" name="nazwa" />
      <br />
      <input type="submit" value="Upload File" />
      </form>
      <br/> -----------------------------------------------<br/>
      <h1>Delete font!</h1>
    <form action="FontDelete.jsp" method="post"> 
        <select name="idfont">
            <%
                //Przeslanie wartosc Id poszczegolnych notatek, aby przeslac je do usuniecia
                for(Czcionka czcionka:czcionki){
                out.println("<option value =\""+czcionka.getId()+"\">"+czcionka.getNazwa() +" </option>");
                }
            %>
        </select>
        <input type="submit" value="Usun" />
    </form>
    <br/> -----------------------------------------------<br/>
    <h1>Show font!</h1>
    <form action="show.jsp" method="post"> 
        <select name="idfont">
            <%
                //Przeslanie wartosc Id poszczegolnych notatek, aby przeslac je do usuniecia
                for(Czcionka czcionka:czcionki){
                out.println("<option value =\""+czcionka.getId()+"\">"+czcionka.getNazwa() +" </option>");
                }
            %>
        </select>
        <input type="submit" value="Usun" />
    </form>
    </body>
</html>
