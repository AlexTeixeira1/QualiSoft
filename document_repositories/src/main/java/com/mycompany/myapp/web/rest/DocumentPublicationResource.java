package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.DocumentPublicationRepository;
import com.mycompany.myapp.service.DocumentPublicationService;
import com.mycompany.myapp.service.dto.DocumentPublicationDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.DocumentPublication}.
 */
@RestController
@RequestMapping("/api")
public class DocumentPublicationResource {

    private final Logger log = LoggerFactory.getLogger(DocumentPublicationResource.class);

    private final DocumentPublicationService documentPublicationService;

    private final DocumentPublicationRepository documentPublicationRepository;

    public DocumentPublicationResource(
        DocumentPublicationService documentPublicationService,
        DocumentPublicationRepository documentPublicationRepository
    ) {
        this.documentPublicationService = documentPublicationService;
        this.documentPublicationRepository = documentPublicationRepository;
    }

    /**
     * {@code GET  /document-publications} : get all the documentPublications.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of documentPublications in body.
     */
    @GetMapping("/document-publications")
    public List<DocumentPublicationDTO> getAllDocumentPublications() {
        log.debug("REST request to get all DocumentPublications");
        return documentPublicationService.findAll();
    }

    /**
     * {@code GET  /document-publications/:id} : get the "id" documentPublication.
     *
     * @param id the id of the documentPublicationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the documentPublicationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/document-publications/{id}")
    public ResponseEntity<DocumentPublicationDTO> getDocumentPublication(@PathVariable Long id) {
        log.debug("REST request to get DocumentPublication : {}", id);
        Optional<DocumentPublicationDTO> documentPublicationDTO = documentPublicationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(documentPublicationDTO);
    }
}
