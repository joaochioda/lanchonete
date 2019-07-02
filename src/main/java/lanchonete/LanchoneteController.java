package lanchonete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanchoneteController {
    @Autowired
    private LanchoneteService lanchoneteService;

    @RequestMapping("/lanches")
    public List<Lanche> getAllLanches() {
        return lanchoneteService.getAllLanches();
    }

    @RequestMapping("/lanches/{id}")
    public Lanche getLanche(@PathVariable String id){
        return lanchoneteService.getLanche(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/lanches")
    public void addLanche(@RequestBody Lanche lanche) {
        lanchoneteService.addLanche(lanche);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/lanches/{id}")
    public void updateLanche(@RequestBody Lanche lanche, @PathVariable String id) {
        lanchoneteService.updateLanche(lanche,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/lanches/{id}")
        public void deleteLanche(@PathVariable String id) {
             lanchoneteService.deleteTopic(id);
        }

}
