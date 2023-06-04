<template>
  <div>
    <div v-if="$route.params.taskInstanceId">
      <task-instance-execute :taskInstanceId="$route.params.taskInstanceId" />
    </div>
  </div>
</template>
