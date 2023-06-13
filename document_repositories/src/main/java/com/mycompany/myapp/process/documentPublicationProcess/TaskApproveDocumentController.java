package com.mycompany.myapp.process.documentPublicationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-publication-process/task-approve-document")
public class TaskApproveDocumentController {

    private final Logger log = LoggerFactory.getLogger(TaskApproveDocumentController.class);

    private final TaskApproveDocumentService taskApproveDocumentService;

    public TaskApproveDocumentController(TaskApproveDocumentService taskApproveDocumentService) {
        this.taskApproveDocumentService = taskApproveDocumentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskApproveDocumentContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskApproveDocumentContextDTO taskApproveDocumentContext = taskApproveDocumentService.loadContext(id);
        return ResponseEntity.ok(taskApproveDocumentContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskApproveDocumentContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskApproveDocumentContextDTO taskApproveDocumentContext = taskApproveDocumentService.claim(id);
        return ResponseEntity.ok(taskApproveDocumentContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskApproveDocumentContextDTO taskApproveDocumentContext) {
        log.debug(
            "REST request to complete DocumentPublicationProcess.TaskApproveDocument {}",
            taskApproveDocumentContext.getTaskInstance().getId()
        );
        taskApproveDocumentService.complete(taskApproveDocumentContext);
        return ResponseEntity.noContent().build();
    }
}
