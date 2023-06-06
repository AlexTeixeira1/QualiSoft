package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.DocumentPublicationProcess} entity.
 */
public class DocumentPublicationProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private DocumentPublicationDTO documentPublication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public DocumentPublicationDTO getDocumentPublication() {
        return documentPublication;
    }

    public void setDocumentPublication(DocumentPublicationDTO documentPublication) {
        this.documentPublication = documentPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DocumentPublicationProcessDTO)) {
            return false;
        }

        DocumentPublicationProcessDTO documentPublicationProcessDTO = (DocumentPublicationProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, documentPublicationProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DocumentPublicationProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", documentPublication=" + getDocumentPublication() +
            "}";
    }
}
