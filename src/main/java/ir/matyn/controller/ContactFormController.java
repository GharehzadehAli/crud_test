package ir.matyn.controller;

import ir.matyn.dto.ContactFormDtoIn;
import ir.matyn.dto.ContactFormDtoOut;
import ir.matyn.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class ContactFormController {

    private final ContactFormService contactFormService;

    @Autowired
    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @ResponseBody
    @GetMapping(value = "/readAll", produces = "application/json")
    public List<ContactFormDtoOut> getForms() {
        return contactFormService.findAll();

    }

    @ResponseBody
    @GetMapping(value = "/readById/{id}", produces = "application/json")
    public ContactFormDtoOut getFormById(@Valid @PathVariable("id") Long id) {
        return contactFormService.findById(id);

    }

    //do we need to return anything?
    @DeleteMapping("/deleteAll")
    public void delete() {
        contactFormService.deleteAll();

    }

    //when I made it public it turned in to yellow. why?
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") long id) {
        contactFormService.deleteById(id);

    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ContactFormDtoIn add(@Valid @RequestBody ContactFormDtoIn contactFormDtoIn) {
        contactFormService.save(contactFormDtoIn);
        return contactFormDtoIn;

    }

    //how does this validate Id?
    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
    public void updateById(@Valid @PathVariable("id") long id, @Valid @RequestBody ContactFormDtoIn contactFormDtoIn) {
        contactFormService.updateById(id, contactFormDtoIn);

    }
}
