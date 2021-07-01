<template>
  <div class="grid grid-cols-5 container">
    <Players/>
    <div class="col-span-3 flex flex-col bg-green-300"></div>
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
import Players from "../components/game/Players.vue";

export default defineComponent({
  name: "Game",
  components: {
    Players
  }
});
</script>