package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.DocumentPublicationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DocumentPublication} and its DTO {@link DocumentPublicationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DocumentPublicationMapper extends EntityMapper<DocumentPublicationDTO, DocumentPublication> {}
