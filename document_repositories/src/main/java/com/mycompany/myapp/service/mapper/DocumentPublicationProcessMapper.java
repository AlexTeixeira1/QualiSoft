package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.DocumentPublicationProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DocumentPublicationProcess} and its DTO {@link DocumentPublicationProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, DocumentPublicationMapper.class })
public interface DocumentPublicationProcessMapper extends EntityMapper<DocumentPublicationProcessDTO, DocumentPublicationProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "documentPublication", source = "documentPublication")
    DocumentPublicationProcessDTO toDto(DocumentPublicationProcess s);
}
