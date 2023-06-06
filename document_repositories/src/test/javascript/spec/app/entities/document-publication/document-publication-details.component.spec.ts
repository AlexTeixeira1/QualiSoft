/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import DocumentPublicationDetailComponent from '@/entities/document-publication/document-publication-details.vue';
import DocumentPublicationClass from '@/entities/document-publication/document-publication-details.component';
import DocumentPublicationService from '@/entities/document-publication/document-publication.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('DocumentPublication Management Detail Component', () => {
    let wrapper: Wrapper<DocumentPublicationClass>;
    let comp: DocumentPublicationClass;
    let documentPublicationServiceStub: SinonStubbedInstance<DocumentPublicationService>;

    beforeEach(() => {
      documentPublicationServiceStub = sinon.createStubInstance<DocumentPublicationService>(DocumentPublicationService);

      wrapper = shallowMount<DocumentPublicationClass>(DocumentPublicationDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { documentPublicationService: () => documentPublicationServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundDocumentPublication = { id: 123 };
        documentPublicationServiceStub.find.resolves(foundDocumentPublication);

        // WHEN
        comp.retrieveDocumentPublication(123);
        await comp.$nextTick();

        // THEN
        expect(comp.documentPublication).toBe(foundDocumentPublication);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundDocumentPublication = { id: 123 };
        documentPublicationServiceStub.find.resolves(foundDocumentPublication);

        // WHEN
        comp.beforeRouteEnter({ params: { documentPublicationId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.documentPublication).toBe(foundDocumentPublication);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
