package infobolt.model;

import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;

import java.time.LocalDate;

public class Alkatresz {
    private String marka;
    private String tipus;
    private String azonosito;
    private int gyartasiev;
    private int garanciaevben;
    private String leiras;

    public Alkatresz() {
    }

    public Alkatresz(String marka, String tipus, String azonosito, int gyartasiev, int garanciaevben, String leiras) {
        setMarka(marka);
        setTipus(tipus);
        setAzonosito(azonosito);
        setGyartasiev(gyartasiev);
        setGaranciaevben(garanciaevben);
        setLeiras(leiras);
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

    public void setGyartasiev(int gyartasiev) throws RosszGyartasiev{
        if(gyartasiev<0 || gyartasiev> LocalDate.now().getYear()){
            throw new RosszGyartasiev(String.valueOf(gyartasiev));
        }
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