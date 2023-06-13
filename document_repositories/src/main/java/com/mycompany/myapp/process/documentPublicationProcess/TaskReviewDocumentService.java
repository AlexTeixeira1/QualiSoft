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
public class TaskReviewDocumentService {

    private final TaskInstanceService taskInstanceService;

    private final DocumentPublicationService documentPublicationService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final DocumentPublicationProcessRepository documentPublicationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskReviewDocumentMapper taskReviewDocumentMapper;

    private final DocumentPublicationProcessMapper documentPublicationProcessMapper;

    public TaskReviewDocumentService(
        TaskInstanceService taskInstanceService,
        DocumentPublicationService documentPublicationService,
        TaskInstanceRepository taskInstanceRepository,
        DocumentPublicationProcessRepository documentPublicationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskReviewDocumentMapper taskReviewDocumentMapper,
        DocumentPublicationProcessMapper documentPublicationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.documentPublicationService = documentPublicationService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.documentPublicationProcessRepository = documentPublicationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskReviewDocumentMapper = taskReviewDocumentMapper;
        this.documentPublicationProcessMapper = documentPublicationProcessMapper;
    }

    public TaskReviewDocumentContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskReviewDocumentMapper::toDocumentPublicationProcessDTO)
            .orElseThrow();

        TaskReviewDocumentContextDTO taskReviewDocumentContext = new TaskReviewDocumentContextDTO();
        taskReviewDocumentContext.setTaskInstance(taskInstanceDTO);
        taskReviewDocumentContext.setDocumentPublicationProcess(documentPublicationProcess);

        return taskReviewDocumentContext;
    }

    public TaskReviewDocumentContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskReviewDocumentContextDTO taskReviewDocumentContext) {
        DocumentPublicationDTO documentPublicationDTO = documentPublicationService
            .findOne(taskReviewDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getId())
            .orElseThrow();
        documentPublicationDTO.setName(taskReviewDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getName());
        documentPublicationDTO.setStartDate(
            taskReviewDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getStartDate()
        );
        documentPublicationDTO.setEndDate(taskReviewDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getEndDate());
        documentPublicationDTO.setDocumentId(
            taskReviewDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getDocumentId()
        );
        documentPublicationDTO.setComment(taskReviewDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getComment());
        documentPublicationService.save(documentPublicationDTO);
    }

    public void complete(TaskReviewDocumentContextDTO taskReviewDocumentContext) {
        save(taskReviewDocumentContext);
        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskReviewDocumentContext.getDocumentPublicationProcess().getProcessInstance().getId())
            .map(documentPublicationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskReviewDocumentContext.getTaskInstance(), documentPublicationProcess);
    }
}
