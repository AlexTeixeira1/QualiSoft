package com.mycompany.myapp.process.documentPublicationProcess;

import com.mycompany.myapp.repository.DocumentPublicationProcessRepository;
import com.mycompany.myapp.service.DocumentPublicationService;
import com.mycompany.myapp.service.dto.DocumentPublicationDTO;
import com.mycompany.myapp.service.dto.DocumentPublicationProcessDTO;
import com.mycompany.myapp.service.mapper.DocumentPublicationProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskCreateDocumentService {

    private final TaskInstanceService taskInstanceService;

    private final DocumentPublicationService documentPublicationService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final DocumentPublicationProcessRepository documentPublicationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskCreateDocumentMapper taskCreateDocumentMapper;

    private final DocumentPublicationProcessMapper documentPublicationProcessMapper;

    public TaskCreateDocumentService(
        TaskInstanceService taskInstanceService,
        DocumentPublicationService documentPublicationService,
        TaskInstanceRepository taskInstanceRepository,
        DocumentPublicationProcessRepository documentPublicationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskCreateDocumentMapper taskCreateDocumentMapper,
        DocumentPublicationProcessMapper documentPublicationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.documentPublicationService = documentPublicationService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.documentPublicationProcessRepository = documentPublicationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskCreateDocumentMapper = taskCreateDocumentMapper;
        this.documentPublicationProcessMapper = documentPublicationProcessMapper;
    }

    public TaskCreateDocumentContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskCreateDocumentMapper::toDocumentPublicationProcessDTO)
            .orElseThrow();

        TaskCreateDocumentContextDTO taskCreateDocumentContext = new TaskCreateDocumentContextDTO();
        taskCreateDocumentContext.setTaskInstance(taskInstanceDTO);
        taskCreateDocumentContext.setDocumentPublicationProcess(documentPublicationProcess);

        return taskCreateDocumentContext;
    }

    public TaskCreateDocumentContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskCreateDocumentContextDTO taskCreateDocumentContext) {
        DocumentPublicationDTO documentPublicationDTO = documentPublicationService
            .findOne(taskCreateDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getId())
            .orElseThrow();
        documentPublicationDTO.setName(taskCreateDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getName());
        documentPublicationDTO.setStartDate(
            taskCreateDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getStartDate()
        );
        documentPublicationDTO.setEndDate(taskCreateDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getEndDate());
        documentPublicationDTO.setDocumentId(
            taskCreateDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getDocumentId()
        );
        documentPublicationDTO.setDocumentType(
            taskCreateDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getDocumentType()
        );
        documentPublicationService.save(documentPublicationDTO);
    }

    public void complete(TaskCreateDocumentContextDTO taskCreateDocumentContext) {
        save(taskCreateDocumentContext);
        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskCreateDocumentContext.getDocumentPublicationProcess().getProcessInstance().getId())
            .map(documentPublicationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskCreateDocumentContext.getTaskInstance(), documentPublicationProcess);
    }
}
