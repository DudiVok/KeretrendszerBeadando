package infobolt.service.impl;

import infobolt.dao.AlkatreszDAO;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.exceptions.RosszAzonosito;
import infobolt.model.Alkatresz;
import infobolt.service.AlkatreszService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class AlkatreszServiceImpl implements AlkatreszService {
    private AlkatreszDAO dao;

    public AlkatreszServiceImpl(AlkatreszDAO dao) {
        this.dao = dao;
    }

    public Collection<Alkatresz> listAllAlkatresz() {
        return dao.readAllAlkatresz();
    }

    public Alkatresz getAlkatresz(String azonosito) throws RosszAzonosito, AlkatreszNemTalalhato {
        return null;
    }

    public void addAlkatresz(Alkatresz alkatresz) throws RosszGyartasiev, RosszAzonosito{

    }

    public void delAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato {
        
    }

    public Collection<Alkatresz> listAllAlkatreszGyartoAlapjan(String gyarto) {
        Collection<Alkatresz> allAlkatresz = dao.readAllAlkatresz();
        Collection<Alkatresz> result = new ArrayList<Alkatresz>();
        for (Alkatresz a: allAlkatresz){
            if(a.getMarka().equalsIgnoreCase(gyarto)){
                result.add(a);
            }

        }
        return result;
    }
}