package com.mycompany.myapp.process.documentPublicationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-publication-process/task-publish-document")
public class TaskPublishDocumentController {

    private final Logger log = LoggerFactory.getLogger(TaskPublishDocumentController.class);

    private final TaskPublishDocumentService taskPublishDocumentService;

    public TaskPublishDocumentController(TaskPublishDocumentService taskPublishDocumentService) {
        this.taskPublishDocumentService = taskPublishDocumentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskPublishDocumentContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPublishDocumentContextDTO taskPublishDocumentContext = taskPublishDocumentService.loadContext(id);
        return ResponseEntity.ok(taskPublishDocumentContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskPublishDocumentContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPublishDocumentContextDTO taskPublishDocumentContext = taskPublishDocumentService.claim(id);
        return ResponseEntity.ok(taskPublishDocumentContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskPublishDocumentContextDTO taskPublishDocumentContext) {
        log.debug(
            "REST request to complete DocumentPublicationProcess.TaskPublishDocument {}",
            taskPublishDocumentContext.getTaskInstance().getId()
        );
        taskPublishDocumentService.complete(taskPublishDocumentContext);
        return ResponseEntity.noContent().build();
    }
}
