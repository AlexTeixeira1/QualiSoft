package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentPublicationMapperTest {

    private DocumentPublicationMapper documentPublicationMapper;

    @BeforeEach
    public void setUp() {
        documentPublicationMapper = new DocumentPublicationMapperImpl();
    }
}
