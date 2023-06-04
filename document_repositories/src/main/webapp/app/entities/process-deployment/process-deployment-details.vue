<template>
  <div>
    <div v-if="$route.params.processDeploymentId">
      <process-deployment-details :processDeploymentId="$route.params.processDeploymentId" />
    </div>
  </div>
</template>
