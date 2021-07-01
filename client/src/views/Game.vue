<template>
  <div class="grid grid-cols-5 container">
    <div class="bg-red-500">PLAYERS</div>
    <div class="col-span-3 bg-blue-500">GAME</div>
    <div class="bg-green-500">CHAT</div>
  </div>
</template>

<style>
.container {
  min-width: 100vw;
  min-height: 100vh;
}
</style>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: "Game"
});
</script>