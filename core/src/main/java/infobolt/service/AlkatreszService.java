package infobolt.service;

import infobolt.model.Alkatresz;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.exceptions.RosszAzonosito;

import java.util.Collection;

public interface AlkatreszService {
    Collection<Alkatresz> listAllAlkatresz();
    Alkatresz getAlkatresz(String azonosito) throws RosszAzonosito, AlkatreszNemTalalhato;
    void addAlkatresz(Alkatresz alkatresz) throws RosszGyartasiev, RosszAzonosito;
    void delAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato;
    void updateAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato;
    Collection<Alkatresz> listAllAlkatreszGyartoAlapjan(String gyarto);
}
