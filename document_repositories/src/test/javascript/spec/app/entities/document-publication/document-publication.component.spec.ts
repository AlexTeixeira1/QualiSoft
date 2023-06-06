/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import DocumentPublicationComponent from '@/entities/document-publication/document-publication.vue';
import DocumentPublicationClass from '@/entities/document-publication/document-publication.component';
import DocumentPublicationService from '@/entities/document-publication/document-publication.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('DocumentPublication Management Component', () => {
    let wrapper: Wrapper<DocumentPublicationClass>;
    let comp: DocumentPublicationClass;
    let documentPublicationServiceStub: SinonStubbedInstance<DocumentPublicationService>;

    beforeEach(() => {
      documentPublicationServiceStub = sinon.createStubInstance<DocumentPublicationService>(DocumentPublicationService);
      documentPublicationServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<DocumentPublicationClass>(DocumentPublicationComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          documentPublicationService: () => documentPublicationServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      documentPublicationServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllDocumentPublications();
      await comp.$nextTick();

      // THEN
      expect(documentPublicationServiceStub.retrieve.called).toBeTruthy();
      expect(comp.documentPublications[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
