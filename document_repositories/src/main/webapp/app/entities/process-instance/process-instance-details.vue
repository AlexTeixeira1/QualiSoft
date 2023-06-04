<template>
  <div>
    <div v-if="$route.params.processInstanceId">
      <process-instance-details :processInstanceId="$route.params.processInstanceId" />
    </div>
  </div>
</template>
