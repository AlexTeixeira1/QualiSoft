package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.DocumentPublication;
import com.mycompany.myapp.repository.DocumentPublicationRepository;
import com.mycompany.myapp.service.dto.DocumentPublicationDTO;
import com.mycompany.myapp.service.mapper.DocumentPublicationMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link DocumentPublication}.
 */
@Service
@Transactional
public class DocumentPublicationService {

    private final Logger log = LoggerFactory.getLogger(DocumentPublicationService.class);

    private final DocumentPublicationRepository documentPublicationRepository;

    private final DocumentPublicationMapper documentPublicationMapper;

    public DocumentPublicationService(
        DocumentPublicationRepository documentPublicationRepository,
        DocumentPublicationMapper documentPublicationMapper
    ) {
        this.documentPublicationRepository = documentPublicationRepository;
        this.documentPublicationMapper = documentPublicationMapper;
    }

    /**
     * Save a documentPublication.
     *
     * @param documentPublicationDTO the entity to save.
     * @return the persisted entity.
     */
    public DocumentPublicationDTO save(DocumentPublicationDTO documentPublicationDTO) {
        log.debug("Request to save DocumentPublication : {}", documentPublicationDTO);
        DocumentPublication documentPublication = documentPublicationMapper.toEntity(documentPublicationDTO);
        documentPublication = documentPublicationRepository.save(documentPublication);
        return documentPublicationMapper.toDto(documentPublication);
    }

    /**
     * Partially update a documentPublication.
     *
     * @param documentPublicationDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DocumentPublicationDTO> partialUpdate(DocumentPublicationDTO documentPublicationDTO) {
        log.debug("Request to partially update DocumentPublication : {}", documentPublicationDTO);

        return documentPublicationRepository
            .findById(documentPublicationDTO.getId())
            .map(
                existingDocumentPublication -> {
                    documentPublicationMapper.partialUpdate(existingDocumentPublication, documentPublicationDTO);
                    return existingDocumentPublication;
                }
            )
            .map(documentPublicationRepository::save)
            .map(documentPublicationMapper::toDto);
    }

    /**
     * Get all the documentPublications.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<DocumentPublicationDTO> findAll() {
        log.debug("Request to get all DocumentPublications");
        return documentPublicationRepository
            .findAll()
            .stream()
            .map(documentPublicationMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one documentPublication by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DocumentPublicationDTO> findOne(Long id) {
        log.debug("Request to get DocumentPublication : {}", id);
        return documentPublicationRepository.findById(id).map(documentPublicationMapper::toDto);
    }

    /**
     * Delete the documentPublication by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DocumentPublication : {}", id);
        documentPublicationRepository.deleteById(id);
    }
}
