package infobolt.dao.impl.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import infobolt.dao.AlkatreszDAO;


import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
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
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
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

        try {
            alkatresz.setAzonosito(azonosito);
        } catch (RosszAzonosito rosszAzonosito) {
            rosszAzonosito.printStackTrace();
        }

        Collection<Alkatresz> alkatreszek = readAllAlkatresz();
        for (Alkatresz a : alkatreszek)
            if (a.getAzonosito().equalsIgnoreCase(azonosito))
                return a;
        throw new AlkatreszNemTalalhato();
}

    public void insertAlkatresz(Alkatresz alkatresz) {
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

    @Override
    public void updateAlkatresz(String azonosito, Alkatresz alkatresz) throws RosszAzonosito {
        Collection<Alkatresz> allAlkatresz = readAllAlkatresz();
        Collection<Alkatresz> newAlkatresz = new ArrayList<>();
        Boolean found = false;

        try {
            for (Alkatresz m : allAlkatresz) {
                if (!m.getAzonosito().equalsIgnoreCase(azonosito)) {
                    newAlkatresz.add(m);
                    System.out.println(azonosito);
                    System.out.println(m.getAzonosito() + "\n");
                } else found = true;
            }

            if (found) newAlkatresz.add(alkatresz);

            mapper.writeValue(jsonfile, newAlkatresz);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteAlkatresz(String azonosito){
        Collection<Alkatresz> allAlkatresz = readAllAlkatresz();
        Collection<Alkatresz> newAlkatresz = new ArrayList<Alkatresz>();
        try {
            for (Alkatresz m : allAlkatresz)
                if (!m.getAzonosito().equalsIgnoreCase(azonosito))
                    newAlkatresz.add(m);
            mapper.writeValue(jsonfile, newAlkatresz);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
