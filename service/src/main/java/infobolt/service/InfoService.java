package infobolt.service;

import infobolt.exceptions.AlkatreszMarVan;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.model.Alkatresz;

import java.util.Collection;

public interface InfoService
{
    Collection<Alkatresz> alkatreszek();
    Alkatresz getAlkatresz(String azonosito);
    void addAlkatresz(Alkatresz alkatresz) throws AlkatreszMarVan, RosszAzonosito;
    void deleteAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato;
}
