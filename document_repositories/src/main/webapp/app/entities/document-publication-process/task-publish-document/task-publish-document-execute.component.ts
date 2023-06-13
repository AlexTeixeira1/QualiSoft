import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPublishDocumentService from './task-publish-document.service';
import { TaskPublishDocumentContext } from './task-publish-document.model';

const validations: any = {
  taskContext: {
    documentPublicationProcess: {
      documentPublication: {
        name: {},
        startDate: {},
        endDate: {},
        documentId: {},
        comment: {},
        status: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskPublishDocumentExecuteComponent extends Vue {
  private taskPublishDocumentService: TaskPublishDocumentService = new TaskPublishDocumentService();
  private taskContext: TaskPublishDocumentContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskPublishDocumentService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskPublishDocumentService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
