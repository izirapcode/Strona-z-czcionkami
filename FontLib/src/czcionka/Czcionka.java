/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package czcionka;

import java.io.Serializable;

/**
 *
 * @author JacekKiszonka
 */
public class Czcionka implements Serializable {
    int id;
    String nazwa;
    byte[] czcionka;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public byte[] getCzcionka() {
        return czcionka;
    }

    public void setCzcionka(byte[] czcionka) {
        this.czcionka = czcionka;
    }
}
