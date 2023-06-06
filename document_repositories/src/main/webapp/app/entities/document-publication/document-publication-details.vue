<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="documentPublication">
        <h2 class="jh-entity-heading" data-cy="documentPublicationDetailsHeading">
          <span v-text="$t('documentRepositoriesApp.documentPublication.detail.title')">DocumentPublication</span>
          {{ documentPublication.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.name')">Name</span>
          </dt>
          <dd>
            <span>{{ documentPublication.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.startDate')">Start Date</span>
          </dt>
          <dd>
            <span>{{ documentPublication.startDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.endDate')">End Date</span>
          </dt>
          <dd>
            <span>{{ documentPublication.endDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.documentId')">Document Id</span>
          </dt>
          <dd>
            <span>{{ documentPublication.documentId }}</span>
          </dd>
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.comment')">Comment</span>
          </dt>
          <dd>
            <span>{{ documentPublication.comment }}</span>
          </dd>
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.status')">Status</span>
          </dt>
          <dd>
            <span>{{ documentPublication.status }}</span>
          </dd>
          <dt>
            <span v-text="$t('documentRepositoriesApp.documentPublication.documentType')">Document Type</span>
          </dt>
          <dd>
            <span>{{ documentPublication.documentType }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./document-publication-details.component.ts"></script>
