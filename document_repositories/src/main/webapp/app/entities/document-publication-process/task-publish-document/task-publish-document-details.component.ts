import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPublishDocumentService from './task-publish-document.service';
import { TaskPublishDocumentContext } from './task-publish-document.model';

@Component
export default class TaskPublishDocumentDetailsComponent extends Vue {
  private taskPublishDocumentService: TaskPublishDocumentService = new TaskPublishDocumentService();
  private taskContext: TaskPublishDocumentContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskPublishDocumentService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
