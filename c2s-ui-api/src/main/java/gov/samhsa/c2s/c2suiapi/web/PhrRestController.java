package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.PhrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class PhrRestController {
    private final PhrService phrService;

    @Autowired
    public PhrRestController(PhrService phrService) {
        this.phrService = phrService;
    }

    @GetMapping("/uploadedDocuments/documentTypeCodes")
    public List<Object> getAllDocumentTypeCodesList(){
        return phrService.getAllDocumentTypeCodesList();
    }

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents")
    public List<Object> getPatientDocumentsList(@PathVariable String patientMrn){
        return phrService.getPatientDocumentInfoList(patientMrn);
    }

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents/{id}")
    public Object getPatientDocumentByDocId(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id){
        return phrService.getPatientDocumentByDocId(patientMrn, id);
    }

    @DeleteMapping("/uploadedDocuments/patients/{patientMrn}/documents/{id}")
    public void deletePatientDocument(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id){
        phrService.deletePatientDocument(patientMrn, id);
    }
}
