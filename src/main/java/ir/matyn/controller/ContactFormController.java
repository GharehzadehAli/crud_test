package ir.matyn.controller;

import ir.matyn.model.dto.ContactFormDtoIn;
import ir.matyn.model.dto.ContactFormDtoOut;
import ir.matyn.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact-form")
public class ContactFormController {

    private final ContactFormService contactFormService;

    @Autowired
    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @ResponseBody
    @GetMapping(value = "", produces = "application/json")
    public List<ContactFormDtoOut> getForms() {
        return contactFormService.findAll();

    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = "application/json")
    public ContactFormDtoOut getFormById(@Valid @PathVariable("id") Long id) {
        return contactFormService.findById(id);

    }

    //do we need to return anything?
    @DeleteMapping("")
    public void delete() {
        contactFormService.deleteAll();

    }

    //when I made it public it turned in to yellow. why?
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        contactFormService.deleteById(id);

    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ContactFormDtoOut add(@Valid @RequestBody ContactFormDtoIn contactFormDtoIn) {
        return contactFormService.save(contactFormDtoIn);

    }

    //how does this validate Id?
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ContactFormDtoOut updateById(@Valid @PathVariable("id") long id, @Valid @RequestBody ContactFormDtoIn contactFormDtoIn) {
        return contactFormService.updateById(id, contactFormDtoIn);

    }
}
