package infobolt.controller;

import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.AlkatreszMarVan;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.RosszGyartasiev;
import infobolt.model.Alkatresz;
import infobolt.service.AlkatreszService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class AlkatreszController {
    AlkatreszService service;

    public AlkatreszController(@Autowired(required = true) AlkatreszService service) {
        this.service = service;
    }

    @RequestMapping(value = "collectionsize")
    @ResponseBody
    public String testService() {
        return String.valueOf(service.listAllAlkatresz().size());
    }

    @RequestMapping(value = "/get/{azonosito}")
    @ResponseBody
    public Alkatresz getAlkatresz(@PathVariable(value = "azonosito") String azonosito) throws RosszAzonosito, AlkatreszNemTalalhato {
        return service.getAlkatresz(azonosito);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addAlkatresz(@RequestBody Alkatresz alkatresz) throws RosszAzonosito, RosszGyartasiev, AlkatreszMarVan {
        service.addAlkatresz(alkatresz);
    }

    @RequestMapping(value = "/update/{azonosito}", method = RequestMethod.POST)
    @ResponseBody
    public void updateAlkatresz(@PathVariable(value = "azonosito") String azonosito, @RequestBody Alkatresz alkatresz) throws AlkatreszNemTalalhato, RosszGyartasiev, RosszAzonosito {
        service.updateAlkatresz(azonosito, alkatresz);
    }


    @RequestMapping(value = "/delete/{azonosito}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAlkatresz(@PathVariable(value = "azonosito") String azonosito) throws AlkatreszNemTalalhato {
        service.delAlkatresz(azonosito);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Alkatresz> getAllAlkatresz() {
        return service.listAllAlkatresz();
    }

    @RequestMapping(value = "/listGyarto/{gyarto}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Alkatresz> listByGyarto(@PathVariable(value = "gyarto") String gyarto) {
        return service.listAllAlkatreszGyartoAlapjan(gyarto);
    }
}
