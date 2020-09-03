<template>
  <div id="app">
    <router-view/>
    <!--路由视图，当前路由指向的内容将显示在这个容器中。
    其它的组件即使拥有自己的路由(URL，需要在 router 文件夹的 index.js 文件里定义)
    也只不过表面上是一个单独的页面，实际上只是在根组件 App.vue 中。-->
  </div>
</template>

<script>

//ES6 的语法，将这个组件整体导出
export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
