import { Component, Vue, Inject } from 'vue-property-decorator';

import { IDocumentPublicationProcess, DocumentPublicationProcess } from '@/shared/model/document-publication-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { DocumentPublication } from '@/shared/model/document-publication.model';
import DocumentPublicationProcessService from './document-publication-process.service';

const validations: any = {
  documentPublicationProcess: {
    documentPublication: {
      name: {},
      startDate: {},
      endDate: {},
    },
  },
};

@Component({
  validations,
})
export default class DocumentPublicationStartFormInitComponent extends Vue {
  @Inject('documentPublicationProcessService') private documentPublicationProcessService: () => DocumentPublicationProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'DocumentPublicationProcess';
  public documentPublicationProcess: IDocumentPublicationProcess = new DocumentPublicationProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initDocumentPublicationStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.documentPublicationProcessService()
      .create(this.documentPublicationProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('documentRepositoriesApp.documentPublicationStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initDocumentPublicationStartForm(): void {
    this.documentPublicationProcess.documentPublication = new DocumentPublication();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.documentPublicationProcess.processInstance = new ProcessInstance();
      this.documentPublicationProcess.processInstance.processDefinition = res;
    });
  }
}
