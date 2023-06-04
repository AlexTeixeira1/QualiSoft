<template>
  <div>
    <div v-if="$route.params.processDefinitionId">
      <process-definition-instances :processDefinitionId="$route.params.processDefinitionId" />
    </div>
  </div>
</template>
