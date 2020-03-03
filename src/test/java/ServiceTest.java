import ir.matyn.model.dto.ContactFormDtoIn;
import ir.matyn.model.dto.ContactFormDtoOut;
import ir.matyn.model.entity.ContactFormEntity;
import ir.matyn.repository.IContactFormDao;
import ir.matyn.service.ContactFormService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ServiceTest {

    List<ContactFormEntity> testCaseList;
    ContactFormEntity testCase1 = new ContactFormEntity();
    ContactFormEntity testCase2 = new ContactFormEntity();
    ContactFormEntity testCase3 = new ContactFormEntity();
    ContactFormEntity testCase4 = new ContactFormEntity();
    @Mock
    private IContactFormDao contactFormDao;
    @InjectMocks
    private ContactFormService contactFormService;


    @Before()
    public void init() {

        MockitoAnnotations.initMocks(this);
        testCase1.setId(1L);
        testCase2.setId(2L);
        testCase3.setId(3L);
        testCase4.setId(4L);
        testCase1.setName("name1");
        testCase2.setName("name2");
        testCase3.setName("name3");
        testCase4.setName("name4");
        testCase1.setEmail("email1");
        testCase2.setEmail("email2");
        testCase3.setEmail("email3");
        testCase4.setEmail("email4");
        testCase1.setSubject("subject1");
        testCase2.setSubject("subject2");
        testCase3.setSubject("subject3");
        testCase4.setSubject("subject4");
        testCase1.setMessage("message1");
        testCase2.setMessage("message2");
        testCase3.setMessage("message3");
        testCase4.setMessage("message4");
        testCaseList = new ArrayList<>();
        testCaseList.add(testCase1);
        testCaseList.add(testCase2);
        testCaseList.add(testCase3);
        testCaseList.add(testCase4);
    }

    @Test
    public void findAll_Test() {

        when(contactFormDao.findAll()).thenReturn(testCaseList);
        List<ContactFormDtoOut> contactFormDtoOutList = contactFormService.findAll();
        for (int i = 0; i < testCaseList.size(); i++) {
            assertEquals(testCaseList.get(i).getId(), contactFormDtoOutList.get(i).getId());
            assertEquals(testCaseList.get(i).getEmail(), contactFormDtoOutList.get(i).getEmail());
            assertEquals(testCaseList.get(i).getName(), contactFormDtoOutList.get(i).getName());
            assertEquals(testCaseList.get(i).getMessage(), contactFormDtoOutList.get(i).getMessage());
            assertEquals(testCaseList.get(i).getSubject(), contactFormDtoOutList.get(i).getSubject());
        }

    }

    @Test
    public void findById_Test() {
        when(contactFormDao.findById(1l)).thenReturn(Optional.of(testCase1));
        ContactFormDtoOut contactFormDtoOut = contactFormService.findById(1);
        assertEquals(testCase1.getEmail(), contactFormDtoOut.getEmail());
        assertEquals(testCase1.getName(), contactFormDtoOut.getName());
        assertEquals(testCase1.getMessage(), contactFormDtoOut.getMessage());
        assertEquals(testCase1.getSubject(), contactFormDtoOut.getSubject());
    }

    @Test
    public void updateById_Test() {
        when(contactFormDao.findById(1l)).thenReturn(Optional.of(testCase1));
        ModelMapper modelMapper = new ModelMapper();
        ContactFormDtoIn testCaseDtoIn2 = modelMapper.map(testCase2, ContactFormDtoIn.class);
        ContactFormDtoOut contactFormDtoOut = contactFormService.updateById(1l, testCaseDtoIn2);
        assertEquals(testCase2.getEmail(), contactFormDtoOut.getEmail());
        assertEquals(testCase2.getName(), contactFormDtoOut.getName());
        assertEquals(testCase2.getMessage(), contactFormDtoOut.getMessage());
        assertEquals(testCase2.getSubject(), contactFormDtoOut.getSubject());
    }
}




