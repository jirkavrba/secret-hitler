<template>
  <div class="app-container">
    <div class="lg:hidden block bg-black flex flex-col items-center justify-center app-container">
      <img alt="Secret Hitler logo" src="./assets/logo.png" class="w-64">

      <div class="my-16">
        <h1 class="text-white text-3xl font-black">Sorry,</h1>
        <h2 class="text-gray-300">
          This shit doesn't work on mobiles
          <span class="text-gray-500">(yet?)</span>
        </h2>
      </div>
    </div>
    <div class="hidden lg:block">
      <router-view/>
    </div>
  </div>
</template>

<style>
.app-container {
  min-height: 100vh;
}
</style>

<script lang="ts">
import {defineComponent} from 'vue'

export default defineComponent({
  name: 'App',
})
</script>