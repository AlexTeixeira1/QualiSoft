package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DocumentPublicationDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DocumentPublicationDTO.class);
        DocumentPublicationDTO documentPublicationDTO1 = new DocumentPublicationDTO();
        documentPublicationDTO1.setId(1L);
        DocumentPublicationDTO documentPublicationDTO2 = new DocumentPublicationDTO();
        assertThat(documentPublicationDTO1).isNotEqualTo(documentPublicationDTO2);
        documentPublicationDTO2.setId(documentPublicationDTO1.getId());
        assertThat(documentPublicationDTO1).isEqualTo(documentPublicationDTO2);
        documentPublicationDTO2.setId(2L);
        assertThat(documentPublicationDTO1).isNotEqualTo(documentPublicationDTO2);
        documentPublicationDTO1.setId(null);
        assertThat(documentPublicationDTO1).isNotEqualTo(documentPublicationDTO2);
    }
}
