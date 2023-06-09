import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const DocumentPublication = () => import('@/entities/document-publication/document-publication.vue');
// prettier-ignore
const DocumentPublicationDetails = () => import('@/entities/document-publication/document-publication-details.vue');
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
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
