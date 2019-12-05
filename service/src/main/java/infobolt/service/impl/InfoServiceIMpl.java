package infobolt.service.impl;

import infobolt.dao.AlkatreszDAO;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.model.Alkatresz;
import infobolt.service.AlkatreszService;

import java.util.ArrayList;
import java.util.Collection;

public class InfoServiceIMpl implements AlkatreszService {
    private AlkatreszDAO dao;

    public Collection<Alkatresz> listAllAlkatresz() {
        return this.dao.readAllAlkatresz();
    }

    public Alkatresz getAlkatresz(String azonosito) throws RosszAzonosito, AlkatreszNemTalalhato {
        return dao.readAlkatresz(azonosito);
    }

    public void addAlkatresz(Alkatresz alkatresz) throws RosszGyartasiev, RosszAzonosito {
        dao.insertAlkatresz(alkatresz);
    }

    public void delAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato {
        dao.deleteAlkatresz(alkatresz);
    }

    public Collection<Alkatresz> listAllAlkatreszGyartoAlapjan(String gyarto) {
        Collection<Alkatresz> alkatreszek = dao.readAllAlkatresz();
        Collection<Alkatresz> gyartoalkatreszek = new ArrayList();
        for(Alkatresz a: alkatreszek)
            if (a.getMarka().equalsIgnoreCase(gyarto))
                gyartoalkatreszek.add(a);
        return gyartoalkatreszek;
    }
}
