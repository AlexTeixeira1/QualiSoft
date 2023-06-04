<template>
  <div>
    <div v-if="$route.params.processDefinitionId">
      <process-definition-details :processDefinitionId="$route.params.processDefinitionId" />
    </div>
  </div>
</template>
