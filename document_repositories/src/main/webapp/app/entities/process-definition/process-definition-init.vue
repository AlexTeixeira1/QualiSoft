<template>
  <div>
    <div v-if="$route.params.processDefinitionId">
      <process-definition-init :processDefinitionId="$route.params.processDefinitionId" />
    </div>
  </div>
</template>
