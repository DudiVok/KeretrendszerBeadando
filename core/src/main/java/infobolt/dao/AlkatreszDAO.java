package infobolt.dao;

import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.model.Alkatresz;

import java.util.Collection;

public interface AlkatreszDAO {

    public Collection<Alkatresz> readAllAlkatresz();
    Alkatresz readAlkatresz(String title) throws AlkatreszNemTalalhato;
    void insertAlkatresz(Alkatresz alkatresz);
    void updateAlkatresz(Alkatresz alkatresz);
    void deleteAlkatresz(Alkatresz alkatresz);
}