import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const DocumentPublication = () => import('@/entities/document-publication/document-publication.vue');
// prettier-ignore
const DocumentPublicationDetails = () => import('@/entities/document-publication/document-publication-details.vue');
// prettier-ignore
const DocumentPublicationProcessDetails = () => import('@/entities/document-publication-process/document-publication-process-details.vue');
// prettier-ignore
const DocumentPublicationProcessList = () => import('@/entities/document-publication-process/document-publication-process-list.vue');
// prettier-ignore
const DocumentPublicationStartFormInit = () => import('@/entities/document-publication-process/document-publication-start-form-init.vue');
// prettier-ignore
const DocumentPublicationProcess_TaskCreateDocumentDetails = () => import('@/entities/document-publication-process/task-create-document/task-create-document-details.vue');
// prettier-ignore
const DocumentPublicationProcess_TaskCreateDocumentExecute = () => import('@/entities/document-publication-process/task-create-document/task-create-document-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/document-publication',
    name: 'DocumentPublication',
    component: DocumentPublication,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/document-publication/:documentPublicationId/view',
    name: 'DocumentPublicationView',
    component: DocumentPublicationDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/DocumentPublicationProcess/instance/:processInstanceId/view',
    name: 'DocumentPublicationProcessView',
    component: DocumentPublicationProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/DocumentPublicationProcess/instances',
    name: 'DocumentPublicationProcessList',
    component: DocumentPublicationProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/DocumentPublicationProcess/init',
    name: 'DocumentPublicationStartFormInit',
    component: DocumentPublicationStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/DocumentPublicationProcess/task/TaskCreateDocument/:taskInstanceId/view',
    name: 'DocumentPublicationProcess_TaskCreateDocumentDetails',
    component: DocumentPublicationProcess_TaskCreateDocumentDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/DocumentPublicationProcess/task/TaskCreateDocument/:taskInstanceId/execute',
    name: 'DocumentPublicationProcess_TaskCreateDocumentExecute',
    component: DocumentPublicationProcess_TaskCreateDocumentExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
