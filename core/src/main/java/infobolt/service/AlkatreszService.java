package infobolt.service;

import infobolt.exceptions.AlkatreszMarVan;
import infobolt.model.Alkatresz;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.exceptions.RosszAzonosito;

import java.util.Collection;

public interface AlkatreszService {
    Collection<Alkatresz> listAllAlkatresz();
    Alkatresz getAlkatresz(String azonosito) throws RosszAzonosito, AlkatreszNemTalalhato;
    void addAlkatresz(Alkatresz alkatresz) throws RosszAzonosito, RosszGyartasiev, AlkatreszMarVan;
    void delAlkatresz(String azonosito) throws AlkatreszNemTalalhato;
    void updateAlkatresz(String azonosito, Alkatresz alkatresz) throws RosszAzonosito, RosszGyartasiev, AlkatreszNemTalalhato;
    Collection<Alkatresz> listAllAlkatreszGyartoAlapjan(String gyarto);
}
