<template>
  <div>
    <nav-menu class="nav-menu"></nav-menu>
    <router-view/>
  </div>
</template>

<script>
import NavMenu from '@/components/common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style>
.nav-menu {
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
}
</style>
