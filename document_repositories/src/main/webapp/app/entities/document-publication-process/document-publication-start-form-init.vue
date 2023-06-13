<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="documentRepositoriesApp.documentPublicationStartForm.home.createOrEditLabel"
          data-cy="DocumentPublicationStartFormCreateUpdateHeading"
          v-text="$t('documentRepositoriesApp.documentPublicationStartForm.home.createOrEditLabel')"
        >
          Create or edit a DocumentPublicationStartForm
        </h2>
        <div v-if="documentPublicationProcess.processInstance">
          <akip-show-process-definition :processDefinition="documentPublicationProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="documentPublicationProcess.documentPublication">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('documentRepositoriesApp.documentPublicationStartForm.name')"
                    for="document-publication-start-form-name"
                    >Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="document-publication-start-form-name"
                    data-cy="name"
                    :class="{
                      valid: !$v.documentPublicationProcess.documentPublication.name.$invalid,
                      invalid: $v.documentPublicationProcess.documentPublication.name.$invalid,
                    }"
                    v-model="$v.documentPublicationProcess.documentPublication.name.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('documentRepositoriesApp.documentPublicationStartForm.startDate')"
                    for="document-publication-start-form-startDate"
                    >Start Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="document-publication-start-form-startDate"
                        v-model="$v.documentPublicationProcess.documentPublication.startDate.$model"
                        name="startDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="document-publication-start-form-startDate"
                      data-cy="startDate"
                      type="text"
                      class="form-control"
                      name="startDate"
                      :class="{
                        valid: !$v.documentPublicationProcess.documentPublication.startDate.$invalid,
                        invalid: $v.documentPublicationProcess.documentPublication.startDate.$invalid,
                      }"
                      v-model="$v.documentPublicationProcess.documentPublication.startDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('documentRepositoriesApp.documentPublicationStartForm.endDate')"
                    for="document-publication-start-form-endDate"
                    >End Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="document-publication-start-form-endDate"
                        v-model="$v.documentPublicationProcess.documentPublication.endDate.$model"
                        name="endDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="document-publication-start-form-endDate"
                      data-cy="endDate"
                      type="text"
                      class="form-control"
                      name="endDate"
                      :class="{
                        valid: !$v.documentPublicationProcess.documentPublication.endDate.$invalid,
                        invalid: $v.documentPublicationProcess.documentPublication.endDate.$invalid,
                      }"
                      v-model="$v.documentPublicationProcess.documentPublication.endDate.$model"
                    />
                  </b-input-group>
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.documentPublicationProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./document-publication-start-form-init.component.ts"></script>
