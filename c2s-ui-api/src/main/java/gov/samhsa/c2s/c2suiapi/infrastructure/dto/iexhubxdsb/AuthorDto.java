package gov.samhsa.c2s.c2suiapi.infrastructure.dto.iexhubxdsb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Todo: Remove it when integrate with iexhub-xdsb
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private String providerName;
    private String organizationName;
    private String softwareUse;
    private String nationalProviderId;
    private ContactInfoDto contactInfo;
}
