package infobolt.model;

import java.time.LocalDate;

public class Alkatresz {
    private String marka;
    private String tipus;
    private String azonosito;
    private int gyartasiev;
    private int garanciaevben;
    private string leiras;

    public Alkatresz() {
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(String azonosito) throws RosszAzonosito {
        if(azonosito.matches("^\\w\\w\\d\\d\\d\\d\\d$")){
            this.azonosito = azonosito;
        }
        else{
            throw new RosszAzonosito(azonosito);
        }
    }

    public int getGyartasiev() {
        return gyartasiev;
    }

    public void setGyartasiev(int gyartasiev) {
        this.gyartasiev = gyartasiev;
    }

    public int getGaranciaevben() {
        return garanciaevben;
    }

    public void setGaranciaevben(int garanciaevben) {
        this.garanciaevben = garanciaevben;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
}