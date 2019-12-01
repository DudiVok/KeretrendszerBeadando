package infobolt.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlkatreszTest {
    @Test
    public void testSetAzonosito() {
        String azonosito = "AB12345";
        Alkatresz alkatresz = new Alkatresz();

        try {
            alkatresz.setAzonosito(azonosito);
        } catch (RosszAzonosito rosszAzonosito) {
            rosszAzonosito.printStackTrace();
        }
    }

    @Test(expected = RosszAzonosito.class)
    public void testSetAzonositoWithBadParameter() throws RosszAzonosito {
        String azonosito = "ABC1234";
        Alkatresz alkatresz = new Alkatresz();
        alkatresz.setAzonosito(rendszam);
    }
}