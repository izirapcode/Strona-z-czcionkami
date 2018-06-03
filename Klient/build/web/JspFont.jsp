<%-- 
    Document   : JspFont
    Created on : 2018-02-19, 14:50:12
    Author     : JacekKiszonka
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="czcionka.Czcionka"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.naming.InitialContext"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
        int IdNowejCzcionki = 1;
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
     for(Czcionka czcionka:czcionki){
        if(czcionka.getId()==IdNowejCzcionki)IdNowejCzcionki++;
        out.println("---------------------------<br/>");
        out.println("Nazwa:"+czcionka.getNazwa()+"<br/>");
    }
    %>
       <%
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos;
           String contentType = request.getContentType();
           Czcionka czcionka = new Czcionka();
           czcionka.setId(IdNowejCzcionki);
           if ((contentType.indexOf("multipart/form-data") >= 0)) {
                try {
                     DiskFileItemFactory factory = new DiskFileItemFactory();
                     factory.setRepository(new File("c:\\temp"));
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List fileItems = upload.parseRequest(request);
                    Iterator i = fileItems.iterator();
                    while (i.hasNext()) {
                        FileItem fi = (FileItem) i.next();

                        if (!fi.isFormField()) {
                            czcionka.setCzcionka(fi.get());
                        } else {
                            czcionka.setNazwa(fi.getString());
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                out.println("<br> Added font: " + czcionka.getNazwa());
                out.println("<br> Added font: " + czcionka.getId());
            } else {
                out.println("<p>No file uploaded</p>");
            }
           %>
           <a href="pokaz.jsp">Wroc</a>
  <%
    try {
	wbpack.CzcionkaWebService_Service service = new wbpack.CzcionkaWebService_Service();
	wbpack.CzcionkaWebService port = service.getCzcionkaWebServicePort();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(czcionka);
            oos.flush();
            oos.close();
            bos.close();
	port.dodajCzcionke(bos.toByteArray());
        } catch (Exception ex) {
            System.out.println(ex);
	// TODO handle custom exceptions here
    }
    %>
    </body>
</html>
