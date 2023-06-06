import { Component, Vue, Inject } from 'vue-property-decorator';

import { IDocumentPublication } from '@/shared/model/document-publication.model';
import DocumentPublicationService from './document-publication.service';

@Component
export default class DocumentPublicationDetails extends Vue {
  @Inject('documentPublicationService') private documentPublicationService: () => DocumentPublicationService;
  public documentPublication: IDocumentPublication = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.documentPublicationId) {
        vm.retrieveDocumentPublication(to.params.documentPublicationId);
      }
    });
  }

  public retrieveDocumentPublication(documentPublicationId) {
    this.documentPublicationService()
      .find(documentPublicationId)
      .then(res => {
        this.documentPublication = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
