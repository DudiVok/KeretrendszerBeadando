package infobolt.dao.impl.json;

import infobolt.dao.AlkatreszDAO;


import infobolt.exceptions.AlkatreszMarVan;
import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.model.Alkatresz;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.io.IOException;

public class infoboltDAOJSON implements AlkatreszDAO {

    File jsonfile;

    ObjectMapper mapper;

    public infoboltDAOJSON(String filepath) {
        jsonfile = new File(filepath);
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        if (!jsonfile.exists()) {
            try {
                jsonfile.createNewFile();
                FileWriter writer = new FileWriter(jsonfile);
                writer.write("[]");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Collection<Alkatresz> readAllAlkatresz() {
        Collection<Alkatresz> result = new ArrayList<Alkatresz>();
        try {
            result = mapper.readValue(jsonfile, new TypeReference<ArrayList<Alkatresz>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Alkatresz readAlkatresz(String azonosito) throws AlkatreszNemTalalhato {
        Alkatresz alkatresz = new Alkatresz();
        alkatresz.setAzonosito(azonosito);

        Collection<Alkatresz> alkatreszek = readAllAlkatresz();
        for (Alkatresz a : alkatreszek)
            if (a.getAzonosito().equalsIgnoreCase(azonosito))
                return m;
        throw new AlkatreszNemTalalhato();
}

    public void insertAlkatresz(Alkatresz alkatresz){
        try {
            readAlkatresz(alkatresz.getAzonosito());
        } catch (AlkatreszNemTalalhato alkatresznincs) {
            Collection<Alkatresz> alkatreszek = readAllAlkatresz();
            alkatreszek.add(alkatresz);
            try {
                mapper.writeValue(jsonfile, alkatreszek);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato {
        Collection<Alkatresz> alkatreszek = readAllAlkatresz();
        try {
            Alkatresz selectedAlkatresz = readAlkatresz(alkatresz.getAzonosito());
            alkatreszek.remove(selectedAlkatresz);
            alkatreszek.add(alkatresz);
            mapper.writeValue(jsonfile, alkatreszek);
        } catch (AlkatreszNemTalalhato musicNotFound) {
            musicNotFound.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAlkatresz(Alkatresz alkatresz) throws AlkatreszNemTalalhato {
        Collection<Alkatresz> alkatreszek = readAllAlkatresz();
        try {
            if (alkatreszek.contains(alkatresz)) {
                alkatreszek.remove(alkatresz);
                mapper.writeValue(jsonfile, alkatreszek);
            } else throw new AlkatreszNemTalalhato();
        } catch (AlkatreszNemTalalhato alkatreszNemTalalhato) {
            alkatreszNemTalalhato.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
