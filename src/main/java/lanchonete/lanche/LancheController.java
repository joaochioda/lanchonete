package lanchonete.lanche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LancheController {


    @Autowired
    private LancheService lancheService;

    @RequestMapping("/lanches")
    public List<Lanche> getAllLanches() {
        return lancheService.getAllLanches();
    }

    @RequestMapping(method = RequestMethod.POST, value="/lanches")
    public void addLanche(@RequestBody Lanche lanche) {
        lancheService.addLanche(lanche);
    }
}
