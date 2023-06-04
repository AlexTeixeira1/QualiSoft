<template>
  <div>
    <div v-if="$route.params.taskInstanceId">
      <task-instance-details :taskInstanceId="$route.params.taskInstanceId" />
    </div>
  </div>
</template>
