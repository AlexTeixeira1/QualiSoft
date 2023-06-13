import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCreateDocumentService from './task-create-document.service';
import { TaskCreateDocumentContext } from './task-create-document.model';

@Component
export default class TaskCreateDocumentDetailsComponent extends Vue {
  private taskCreateDocumentService: TaskCreateDocumentService = new TaskCreateDocumentService();
  private taskContext: TaskCreateDocumentContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskCreateDocumentService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
