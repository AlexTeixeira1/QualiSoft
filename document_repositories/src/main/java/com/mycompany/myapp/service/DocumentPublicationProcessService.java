package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.DocumentPublicationProcess;
import com.mycompany.myapp.repository.DocumentPublicationProcessRepository;
import com.mycompany.myapp.repository.DocumentPublicationRepository;
import com.mycompany.myapp.service.dto.DocumentPublicationProcessDTO;
import com.mycompany.myapp.service.mapper.DocumentPublicationProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link DocumentPublicationProcess}.
 */
@Service
@Transactional
public class DocumentPublicationProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "DocumentPublicationProcess";

    private final Logger log = LoggerFactory.getLogger(DocumentPublicationProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final DocumentPublicationRepository documentPublicationRepository;

    private final DocumentPublicationProcessRepository documentPublicationProcessRepository;

    private final DocumentPublicationProcessMapper documentPublicationProcessMapper;

    public DocumentPublicationProcessService(
        ProcessInstanceService processInstanceService,
        DocumentPublicationRepository documentPublicationRepository,
        DocumentPublicationProcessRepository documentPublicationProcessRepository,
        DocumentPublicationProcessMapper documentPublicationProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.documentPublicationRepository = documentPublicationRepository;
        this.documentPublicationProcessRepository = documentPublicationProcessRepository;
        this.documentPublicationProcessMapper = documentPublicationProcessMapper;
    }

    /**
     * Save a documentPublicationProcess.
     *
     * @param documentPublicationProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public DocumentPublicationProcessDTO create(DocumentPublicationProcessDTO documentPublicationProcessDTO) {
        log.debug("Request to save DocumentPublicationProcess : {}", documentPublicationProcessDTO);

        DocumentPublicationProcess documentPublicationProcess = documentPublicationProcessMapper.toEntity(documentPublicationProcessDTO);

        //Saving the domainEntity
        documentPublicationRepository.save(documentPublicationProcess.getDocumentPublication());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "DocumentPublication#" + documentPublicationProcess.getDocumentPublication().getId(),
            documentPublicationProcess
        );
        documentPublicationProcess.setProcessInstance(processInstance);

        //Saving the process entity
        documentPublicationProcess = documentPublicationProcessRepository.save(documentPublicationProcess);
        return documentPublicationProcessMapper.toDto(documentPublicationProcess);
    }

    /**
     * Get all the documentPublicationProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<DocumentPublicationProcessDTO> findAll() {
        log.debug("Request to get all DocumentPublicationProcesss");
        return documentPublicationProcessRepository
            .findAll()
            .stream()
            .map(documentPublicationProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one documentPublicationProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DocumentPublicationProcessDTO> findOne(Long id) {
        log.debug("Request to get DocumentPublicationProcess : {}", id);
        return documentPublicationProcessRepository.findById(id).map(documentPublicationProcessMapper::toDto);
    }

    /**
     * Get one documentPublicationProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DocumentPublicationProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get DocumentPublicationProcess by  processInstanceId: {}", processInstanceId);
        return documentPublicationProcessRepository.findByProcessInstanceId(processInstanceId).map(documentPublicationProcessMapper::toDto);
    }
}
