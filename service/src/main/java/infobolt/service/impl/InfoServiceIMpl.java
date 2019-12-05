package infobolt.service.impl;

import infobolt.dao.AlkatreszDAO;
import infobolt.exceptions.AlkatreszMarVan;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.model.Alkatresz;
import infobolt.service.InfoService;

import java.util.ArrayList;
import java.util.Collection;

public class InfoServiceIMpl implements InfoService{
    private AlkatreszDAO dao;

    public InfoServiceIMpl(AlkatreszDAO dao) { this.dao = dao; }

    public Collection<Alkatresz> alkatreszek() { return this.dao.readAllAlkatresz(); }

    public Alkatresz getAlkatresz(String azonosito) { return null; }

    public void addAlkatresz(Alkatresz alkatresz) { }

    public void deleteAlkatresz(Alkatresz alkatresz) { }

}
