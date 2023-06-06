import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

<<<<<<< Updated upstream
// prettier-ignore
const DocumentPublication = () => import('@/entities/document-publication/document-publication.vue');
// prettier-ignore
const DocumentPublicationDetails = () => import('@/entities/document-publication/document-publication-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
=======
<<<<<<< Updated upstream
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
=======
// prettier-ignore
const DocumentPublication = () => import('@/entities/document-publication/document-publication.vue');
// prettier-ignore
const DocumentPublicationDetails = () => import('@/entities/document-publication/document-publication-details.vue');
// prettier-ignore
const DocumentPublicationProcessDetails = () => import('@/entities/document-publication-process/document-publication-process-details.vue');
// prettier-ignore
const DocumentPublicationProcessList = () => import('@/entities/document-publication-process/document-publication-process-list.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes
>>>>>>> Stashed changes
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
