package infobolt.dao;

import infobolt.exceptions.AlkatreszMarVan;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.model.Alkatresz;

import java.util.Collection;

public interface AlkatreszDAO {

    Collection<Alkatresz> readAllAlkatresz();
    Alkatresz readAlkatresz(String title) throws AlkatreszNemTalalhato;
    void insertAlkatresz(Alkatresz alkatresz) throws RosszAzonosito, RosszGyartasiev, AlkatreszMarVan;
    void updateAlkatresz(String azonosito, Alkatresz alkatresz) throws RosszAzonosito, RosszGyartasiev, AlkatreszNemTalalhato;
    void deleteAlkatresz(String azonosito) throws AlkatreszNemTalalhato;
}