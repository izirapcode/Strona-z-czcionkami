/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wbpack;

import czcionka.Czcionka;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;

/**
 *
 * @author JacekKiszonka
 */
@WebService(serviceName = "CzcionkaWebService")
public class CzcionkaWebService {

    @Resource(name = "connector")
    private DataSource connector;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dodajCzcionke")
    @Oneway
    public void dodajCzcionke(@WebParam(name = "data") byte[] data) {
        PreparedStatement ps;
        String sql = "insert into WELENC.CZCIONKI(ID,NAZWA,CZCIONKA) values ( ?, ? , ? )";
        try {

            Connection con = connector.getConnection("welenc", "welenc");
            ps = con.prepareStatement(sql);
            ByteArrayInputStream bais;
            ObjectInputStream ins;
            bais = new ByteArrayInputStream(data);
            ins = new ObjectInputStream(bais);
            Czcionka czcionka = (Czcionka) ins.readObject();
            ps.setInt(1, czcionka.getId());
            ps.setString(2, czcionka.getNazwa());
            ps.setObject(3, data);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "usunCzcionke")
    @Oneway
    public void usunCzcionke(@WebParam(name = "id") Integer id) {
        String sqlka = "DELETE FROM WELENC.CZCIONKI WHERE ID=" + id;
        try {
            Connection con = connector.getConnection("welenc", "welenc");
            Statement stat = con.createStatement();
            stat.executeUpdate(sqlka);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dajCzcionki")
    public byte[] dajCzcionki() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        sql = "select * from WELENC.CZCIONKI order by ID";
        Vector<Czcionka> czcionki = new Vector<Czcionka>();
        ByteArrayInputStream bais;
        ObjectInputStream ins;
        try {
            Connection con = connector.getConnection("welenc", "welenc");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bais = new ByteArrayInputStream(rs.getBytes("CZCIONKA"));
                ins = new ObjectInputStream(bais);
                czcionki.add((Czcionka) ins.readObject());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(czcionki);
            oos.flush();
            oos.close();
            bos.close();
        } catch (IOException ex) {
        }
        return bos.toByteArray();

    }

}
