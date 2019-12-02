package infobolt.model;

import infobolt.exceptions.RosszAzonosito;
import org.junit.Test;

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