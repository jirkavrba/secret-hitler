<template>
  <div class="absolute left-0 top-0 w-full h-full rounded-3xl highlight bg-gradient-to-br from-yellow-300 to-transparent animate-highlight z-0">
  </div>
</template>

<style scoped>
.animate-highlight {
  animation: 1s highlight infinite alternate ease-in-out;
}

@keyframes highlight{
  from {
    opacity: 0.5;
  }
  to {
    opacity: 0.1;
  }
}
</style>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "Highlight"
})
</script>