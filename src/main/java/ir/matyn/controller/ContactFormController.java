package ir.matyn.controller;

import ir.matyn.dto.ContactFormDto;
import ir.matyn.model.ContactForm;
import ir.matyn.service.ContactFormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class ContactFormController {

    private final ContactFormServiceImpl contactFormService;
    @Autowired
    public ContactFormController(ContactFormServiceImpl contactFormService) {
        this.contactFormService = contactFormService;
    }

    @ResponseBody
    @GetMapping(value = "/read", produces = "application/json")
    public List<ContactFormDto> getForms() {
        List<ContactFormDto> contactFormDtoList = contactFormService.findAll();
        return contactFormDtoList;
    }

    @DeleteMapping("/deleteAll")
    void delete(ContactForm contactForm) {
        contactFormService.deleteAll();

    }

    @DeleteMapping("/deleteById/{id}")
    void delete(@PathVariable("id") long id) {
        contactFormService.deleteById(id);

    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ContactFormDto add(ContactFormDto contactFormDto) {
        contactFormService.save(contactFormDto);
        return contactFormDto;

    }

    @ResponseBody
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public void updateById(@PathVariable("id") long id, @RequestBody ContactFormDto contactFormDto) {
        contactFormService.updateById(id,contactFormDto);

    }
}
