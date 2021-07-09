<template>
  <div class="app-container bg-gray-200">
    <div class="xl:hidden block bg-black flex flex-col items-center justify-center app-container">
      <img alt="Secret Hitler logo" src="./assets/logo.png" class="w-64">

      <div class="my-16">
        <h1 class="text-white text-3xl font-black">Sorry,</h1>
        <h2 class="text-gray-300">
          This shit doesn't work smaller screens
          <span class="text-gray-500">(yet?)</span>
        </h2>
      </div>
    </div>
    <div class="hidden xl:block">
      <router-view/>
    </div>
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Asap:wght@500&display=swap');

.app-container {
  min-height: 100vh;
  font-family: 'Asap', sans-serif;
}
</style>

<script lang="ts">
import {defineComponent} from 'vue'

export default defineComponent({
  name: 'App',
})
</script>