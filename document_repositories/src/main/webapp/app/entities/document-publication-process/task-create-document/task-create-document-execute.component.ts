import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCreateDocumentService from './task-create-document.service';
import { TaskCreateDocumentContext } from './task-create-document.model';

const validations: any = {
  taskContext: {
    documentPublicationProcess: {
      documentPublication: {
        name: {},
        startDate: {},
        endDate: {},
        documentId: {},
        documentType: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskCreateDocumentExecuteComponent extends Vue {
  private taskCreateDocumentService: TaskCreateDocumentService = new TaskCreateDocumentService();
  private taskContext: TaskCreateDocumentContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskCreateDocumentService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskCreateDocumentService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
