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
public class TaskApproveDocumentService {

    private final TaskInstanceService taskInstanceService;

    private final DocumentPublicationService documentPublicationService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final DocumentPublicationProcessRepository documentPublicationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskApproveDocumentMapper taskApproveDocumentMapper;

    private final DocumentPublicationProcessMapper documentPublicationProcessMapper;

    public TaskApproveDocumentService(
        TaskInstanceService taskInstanceService,
        DocumentPublicationService documentPublicationService,
        TaskInstanceRepository taskInstanceRepository,
        DocumentPublicationProcessRepository documentPublicationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskApproveDocumentMapper taskApproveDocumentMapper,
        DocumentPublicationProcessMapper documentPublicationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.documentPublicationService = documentPublicationService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.documentPublicationProcessRepository = documentPublicationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskApproveDocumentMapper = taskApproveDocumentMapper;
        this.documentPublicationProcessMapper = documentPublicationProcessMapper;
    }

    public TaskApproveDocumentContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskApproveDocumentMapper::toDocumentPublicationProcessDTO)
            .orElseThrow();

        TaskApproveDocumentContextDTO taskApproveDocumentContext = new TaskApproveDocumentContextDTO();
        taskApproveDocumentContext.setTaskInstance(taskInstanceDTO);
        taskApproveDocumentContext.setDocumentPublicationProcess(documentPublicationProcess);

        return taskApproveDocumentContext;
    }

    public TaskApproveDocumentContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskApproveDocumentContextDTO taskApproveDocumentContext) {
        DocumentPublicationDTO documentPublicationDTO = documentPublicationService
            .findOne(taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getId())
            .orElseThrow();
        documentPublicationDTO.setName(taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getName());
        documentPublicationDTO.setStartDate(
            taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getStartDate()
        );
        documentPublicationDTO.setEndDate(taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getEndDate());
        documentPublicationDTO.setDocumentId(
            taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getDocumentId()
        );
        documentPublicationDTO.setComment(taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getComment());
        documentPublicationDTO.setStatus(taskApproveDocumentContext.getDocumentPublicationProcess().getDocumentPublication().getStatus());
        documentPublicationService.save(documentPublicationDTO);
    }

    public void complete(TaskApproveDocumentContextDTO taskApproveDocumentContext) {
        save(taskApproveDocumentContext);
        DocumentPublicationProcessDTO documentPublicationProcess = documentPublicationProcessRepository
            .findByProcessInstanceId(taskApproveDocumentContext.getDocumentPublicationProcess().getProcessInstance().getId())
            .map(documentPublicationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskApproveDocumentContext.getTaskInstance(), documentPublicationProcess);
    }
}
