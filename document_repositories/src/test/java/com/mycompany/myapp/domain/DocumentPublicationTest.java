package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DocumentPublicationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DocumentPublication.class);
        DocumentPublication documentPublication1 = new DocumentPublication();
        documentPublication1.setId(1L);
        DocumentPublication documentPublication2 = new DocumentPublication();
        documentPublication2.setId(documentPublication1.getId());
        assertThat(documentPublication1).isEqualTo(documentPublication2);
        documentPublication2.setId(2L);
        assertThat(documentPublication1).isNotEqualTo(documentPublication2);
        documentPublication1.setId(null);
        assertThat(documentPublication1).isNotEqualTo(documentPublication2);
    }
}
