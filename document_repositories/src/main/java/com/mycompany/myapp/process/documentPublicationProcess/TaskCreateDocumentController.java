package com.mycompany.myapp.process.documentPublicationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-publication-process/task-create-document")
public class TaskCreateDocumentController {

    private final Logger log = LoggerFactory.getLogger(TaskCreateDocumentController.class);

    private final TaskCreateDocumentService taskCreateDocumentService;

    public TaskCreateDocumentController(TaskCreateDocumentService taskCreateDocumentService) {
        this.taskCreateDocumentService = taskCreateDocumentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskCreateDocumentContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCreateDocumentContextDTO taskCreateDocumentContext = taskCreateDocumentService.loadContext(id);
        return ResponseEntity.ok(taskCreateDocumentContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskCreateDocumentContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCreateDocumentContextDTO taskCreateDocumentContext = taskCreateDocumentService.claim(id);
        return ResponseEntity.ok(taskCreateDocumentContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskCreateDocumentContextDTO taskCreateDocumentContext) {
        log.debug(
            "REST request to complete DocumentPublicationProcess.TaskCreateDocument {}",
            taskCreateDocumentContext.getTaskInstance().getId()
        );
        taskCreateDocumentService.complete(taskCreateDocumentContext);
        return ResponseEntity.noContent().build();
    }
}
