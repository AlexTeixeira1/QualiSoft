import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const ProcessDefinition = () => import('@/entities/process-definition/process-definition.vue');
// prettier-ignore
const ProcessDefinitionDeploy = () => import('@/entities/process-definition/process-definition-deploy.vue');
// prettier-ignore
const ProcessDefinitionDeployments = () => import('@/entities/process-definition/process-definition-deployments.vue');
// prettier-ignore
const ProcessDefinitionDetails = () => import('@/entities/process-definition/process-definition-details.vue');
// prettier-ignore
const ProcessDefinitionInit = () => import('@/entities/process-definition/process-definition-init.vue');
// prettier-ignore
const ProcessDefinitionInstances = () => import('@/entities/process-definition/process-definition-instances.vue');
// prettier-ignore
const ProcessDeploymentDetails = () => import('@/entities/process-deployment/process-deployment-details.vue');
// prettier-ignore
const ProcessInstance = () => import('@/entities/process-instance/process-instance.vue');
// prettier-ignore
const ProcessInstanceDetails = () => import('@/entities/process-instance/process-instance-details.vue');
// prettier-ignore
const TaskInstance = () => import('@/entities/task-instance/task-instance.vue');
// prettier-ignore
const MyCandidateTaskInstance = () => import('@/entities/task-instance/my-candidate-task-instance.vue');
// prettier-ignore
const TaskInstanceDetails = () => import('@/entities/task-instance/task-instance-details.vue');
// prettier-ignore
const TaskInstanceExecute = () => import('@/entities/task-instance/task-instance-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/process-definitions',
    name: 'ProcessDefinition',
    component: ProcessDefinition,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/deploy',
    name: 'ProcessDefinitionDeploy',
    component: ProcessDefinitionDeploy,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/deployments',
    name: 'ProcessDefinitionDeployments',
    component: ProcessDefinitionDeployments,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/view',
    name: 'ProcessDefinitionView',
    component: ProcessDefinitionDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/init',
    name: 'ProcessDefinitionInit',
    component: ProcessDefinitionInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/instances',
    name: 'ProcessDefinitionInstances',
    component: ProcessDefinitionInstances,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-deployment/:processDeploymentId/view',
    name: 'ProcessDeploymentView',
    component: ProcessDeploymentDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-instances',
    name: 'ProcessInstance',
    component: ProcessInstance,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/instance/:processInstanceId/view',
    name: 'ProcessInstanceView',
    component: ProcessInstanceDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/task-instances',
    name: 'TaskInstance',
    component: TaskInstance,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/my-candidate-tasks',
    name: 'MyCandidateTaskInstance',
    component: MyCandidateTaskInstance,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/task/:taskDefinitionKey/:taskInstanceId/view',
    name: 'TaskInstanceView',
    component: TaskInstanceDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/:processDefinitionId/task/:taskDefinitionKey/:taskInstanceId/execute',
    name: 'TaskInstanceExecute',
    component: TaskInstanceExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
