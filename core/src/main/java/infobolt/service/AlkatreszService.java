package infobolt.service;

import infobolt.model.Alkatresz;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.exceptions.RosszAzonosito;

import java.util.Collection;

public interface AlkatreszService {
    public Collection<Alkatresz> listAllAlkatresz();

    public Alkatresz getAlkatresz(String azonosito) throws RosszAzonosito, AlkatreszNemTalalhato;

    public void addAlkatresz(Alkatresz alkatresz) throws RosszGyartasiev, RosszAzonosito;

    public void delAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato;

    public Collection<Alkatresz> listAllAlkatreszGyartoAlapjan(String gyarto);
}
