package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.DocumentPublicationProcessService;
import com.mycompany.myapp.service.dto.DocumentPublicationProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.DocumentPublicationProcess}.
 */
@RestController
@RequestMapping("/api")
public class DocumentPublicationProcessResource {

    private final Logger log = LoggerFactory.getLogger(DocumentPublicationProcessResource.class);

    private static final String ENTITY_NAME = "documentPublicationProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DocumentPublicationProcessService documentPublicationProcessService;

    public DocumentPublicationProcessResource(DocumentPublicationProcessService documentPublicationProcessService) {
        this.documentPublicationProcessService = documentPublicationProcessService;
    }

    /**
     * {@code POST  /document-publication-processes} : Create a new documentPublicationProcess.
     *
     * @param documentPublicationProcessDTO the documentPublicationProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new documentPublicationProcessDTO, or with status {@code 400 (Bad Request)} if the documentPublicationProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/document-publication-processes")
    public ResponseEntity<DocumentPublicationProcessDTO> create(@RequestBody DocumentPublicationProcessDTO documentPublicationProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save DocumentPublicationProcess : {}", documentPublicationProcessDTO);
        if (documentPublicationProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new documentPublicationProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DocumentPublicationProcessDTO result = documentPublicationProcessService.create(documentPublicationProcessDTO);
        return ResponseEntity
            .created(new URI("/api/document-publication-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /document-publication-processes} : get all the documentPublicationProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of documentPublicationProcesss in body.
     */
    @GetMapping("/document-publication-processes")
    public List<DocumentPublicationProcessDTO> getAllDocumentPublicationProcesss() {
        log.debug("REST request to get all DocumentPublicationProcesss");
        return documentPublicationProcessService.findAll();
    }

    /**
     * {@code GET  /document-publication-processes/:id} : get the "id" documentPublicationProcess.
     *
     * @param processInstanceId the id of the documentPublicationProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the documentPublicationProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/document-publication-processes/{processInstanceId}")
    public ResponseEntity<DocumentPublicationProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get DocumentPublicationProcess by processInstanceId : {}", processInstanceId);
        Optional<DocumentPublicationProcessDTO> documentPublicationProcessDTO = documentPublicationProcessService.findByProcessInstanceId(
            processInstanceId
        );
        return ResponseUtil.wrapOrNotFound(documentPublicationProcessDTO);
    }
}
