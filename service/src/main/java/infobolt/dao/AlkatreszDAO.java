package infobolt.dao;

import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.model.Alkatresz;

import java.util.Collection;

public interface AlkatreszDAO {

    public Collection<Alkatresz> readAllAlkatresz();
    Alkatresz readAlkatresz(String title) throws AlkatreszNemTalalhato, RosszAzonosito;
    void insertAlkatresz(Alkatresz alkatresz) throws RosszAzonosito;
    void updateAlkatresz(Alkatresz alkatresz) throws RosszAzonosito;
    void deleteAlkatresz(Alkatresz alkatresz);
}