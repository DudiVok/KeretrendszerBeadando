package infobolt.model;

import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;

import java.time.LocalDate;

public class Alkatresz {
    private String marka;
    private String tipus;
    private String azonosito;
    private LocalDate gyartasiev;
    private String garanciaevben;
    private String leiras;
    private Allapot allapot;

    public Alkatresz() { }

    public Alkatresz(String marka, String tipus, String azonosito, LocalDate gyartasiev, String garanciaevben, String leiras, Allapot allapot) throws RosszAzonosito, RosszGyartasiev {
        this();
        setMarka(marka);
        setTipus(tipus);
        setAzonosito(azonosito);
        setGyartasiev(gyartasiev);
        setGaranciaevben(garanciaevben);
        setLeiras(leiras);
        setAllapot(allapot);
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
        if(azonosito.length() > 6 && azonosito.length() < 8 && !azonosito.contains("-")) this.azonosito = azonosito; //azonosito.matches("^[A-Z]{2}[0-9]{5}$")
        else throw new RosszAzonosito(azonosito);
    }

    public LocalDate getGyartasiev() {
        return gyartasiev;
    }

    public void setGyartasiev(LocalDate gyartasiev) throws RosszGyartasiev{
        if (gyartasiev.isAfter(LocalDate.MIN) && gyartasiev.isBefore(LocalDate.now())) this.gyartasiev = gyartasiev;
        else throw new RosszGyartasiev(gyartasiev);
    }

    public String getGaranciaevben() {
        return garanciaevben;
    }

    public void setGaranciaevben(String garanciaevben) {
        this.garanciaevben = garanciaevben;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Allapot getAllapot() {
        return allapot;
    }
    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }

    @Override
    public String toString() {
        return "Alkatrész:{" +
                "Márka='" + marka + '\'' +
                ", Típus='" + tipus + '\'' +
                ", Azonosító='" + azonosito + '\'' +
                ", Gyártási év=" + gyartasiev +
                ", Garancia évben=" + garanciaevben + " év" +
                ", Állapot=" + allapot +
                ", Leírás=" + leiras +
                '}';
    }
}