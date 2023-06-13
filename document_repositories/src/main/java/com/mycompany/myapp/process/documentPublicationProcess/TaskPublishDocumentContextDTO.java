package com.mycompany.myapp.process.documentPublicationProcess;

import com.mycompany.myapp.service.dto.DocumentPublicationProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskPublishDocumentContextDTO {

    private DocumentPublicationProcessDTO documentPublicationProcess;
    private TaskInstanceDTO taskInstance;

    public DocumentPublicationProcessDTO getDocumentPublicationProcess() {
        return documentPublicationProcess;
    }

    public void setDocumentPublicationProcess(DocumentPublicationProcessDTO documentPublicationProcess) {
        this.documentPublicationProcess = documentPublicationProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
