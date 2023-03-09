package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Models.Person;
import web.dao.PersonDAOImpl;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAOImpl personDAOImpl;

    public PeopleController(PersonDAOImpl personDAOImpl) {
        this.personDAOImpl = personDAOImpl;
    }

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("people", personDAOImpl.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAOImpl.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAOImpl.save(person);
        return "redirect:/people/all";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAOImpl.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDAOImpl.update(id, person);
        return "redirect:/people/all";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAOImpl.delete(id);
        return "redirect:/people/all";
    }
}
