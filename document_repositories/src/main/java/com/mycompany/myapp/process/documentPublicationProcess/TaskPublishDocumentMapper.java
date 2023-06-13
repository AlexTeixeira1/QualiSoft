package com.mycompany.myapp.process.documentPublicationProcess;

import com.mycompany.myapp.domain.DocumentPublication;
import com.mycompany.myapp.domain.DocumentPublicationProcess;
import com.mycompany.myapp.service.dto.DocumentPublicationDTO;
import com.mycompany.myapp.service.dto.DocumentPublicationProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskPublishDocumentMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    DocumentPublicationProcessDTO toDocumentPublicationProcessDTO(DocumentPublicationProcess documentPublicationProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "documentId", source = "documentId")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "status", source = "status")
    DocumentPublicationDTO toDocumentPublicationDTO(DocumentPublication documentPublication);
}
