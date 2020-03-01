package ir.matyn.controller;

import ir.matyn.dto.ContactFormDtoIn;
import ir.matyn.dto.ContactFormDtoOut;
import ir.matyn.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/read", produces = "application/json")
    public List<ContactFormDtoOut> getForms() {
        return contactFormService.findAll();

    }

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
    public ContactFormDtoIn add(ContactFormDtoIn contactFormDtoIn) {
        contactFormService.save(contactFormDtoIn);
        return contactFormDtoIn;

    }

    @ResponseBody
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public void updateById(@PathVariable("id") long id, @RequestBody ContactFormDtoIn contactFormDtoIn) {
        contactFormService.updateById(id, contactFormDtoIn);

    }
}
