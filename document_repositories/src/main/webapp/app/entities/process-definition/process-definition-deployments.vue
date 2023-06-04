<template>
  <div>
    <div v-if="$route.params.processDefinitionId">
      <process-definition-deployments :processDefinitionId="$route.params.processDefinitionId" />
    </div>
  </div>
</template>
