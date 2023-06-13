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
public class TaskPublishDocumentService {

    private final TaskInstanceService taskInstanceService;

    private final DocumentPublicationService documentPublicationService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final DocumentPublicationProcessRepository documentPublicationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskPublishDocumentMapper taskPublishDocumentMapper;

    private final DocumentPublicationProcessMapper documentPublicationProcessMapper;

    public TaskPublishDocumentService(
        TaskInstanceService taskInstanceService,
        DocumentPublicationService documentPublicationService,
        TaskInstanceRepository taskInstanceRepository,
        DocumentPublicationProcessRepository documentPublicationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskPublishDocumentMapper taskPublishDocumentMapper,
        DocumentPublicationProcessMapper documentPublicationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.documentPublicationService = documentPublicationService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.documentPublicationProcessRepository = documentPublicationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskPublishDocumentMapper = taskPublishDocumentMapper;
        this.documentPublicationProcessMapper = documentPublicationProcessMapper;
    }

    public TaskPublishDocumentContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskPublishDocumentMapper::toDocumentPublicationProcessDTO)
            .orElseThrow();

        TaskPublishDocumentContextDTO taskPublishDocumentContext = new TaskPublishDocumentContextDTO();
        taskPublishDocumentContext.setTaskInstance(taskInstanceDTO);
        taskPublishDocumentContext.setDocumentPublicationProcess(documentPublicationProcess);

        return taskPublishDocumentContext;
    }

    public TaskPublishDocumentContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskPublishDocumentContextDTO taskPublishDocumentContext) {
        DocumentPublicationDTO documentPublicationDTO = documentPublicationService
            .findOne(taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getId())
            .orElseThrow();
        documentPublicationDTO.setName(taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getName());
        documentPublicationDTO.setStartDate(
            taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getStartDate()
        );
        documentPublicationDTO.setEndDate(taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getEndDate());
        documentPublicationDTO.setDocumentId(
            taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getDocumentId()
        );
        documentPublicationDTO.setComment(taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getComment());
        documentPublicationDTO.setStatus(taskPublishDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getStatus());
        documentPublicationService.save(documentPublicationDTO);
    }

    public void complete(TaskPublishDocumentContextDTO taskPublishDocumentContext) {
        save(taskPublishDocumentContext);
        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskPublishDocumentContext.getDocumentPublicationProcess().getProcessInstance().getId())
            .map(documentPublicationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskPublishDocumentContext.getTaskInstance(), documentPublicationProcess);
    }
}
