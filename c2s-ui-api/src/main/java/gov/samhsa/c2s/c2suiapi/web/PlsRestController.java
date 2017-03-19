package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.PlsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.PlsService;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pls")
public class PlsRestController implements PlsService {

    @Autowired
    private PlsClient plsClient;

    @Override
    public PagedResources<FlattenedSmallProviderDto> searchProviders(
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "zipcode", required = false) String zipCode,
            @RequestParam(value = "firstname", required = false) String firstName,
            @RequestParam(value = "lastname", required = false) String lastName,
            @RequestParam(value = "gendercode", required = false) String genderCode,
            @RequestParam(value = "orgname", required = false) String orgName,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "projection", defaultValue = Projection.FLATTEN_SMALL_PROVIDER) String projection) {
        return plsClient.searchProviders(state, city, zipCode, firstName, lastName, genderCode,
                orgName, phone, page, size, sort, projection);
    }
}