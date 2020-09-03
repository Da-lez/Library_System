<template>
  <el-menu
      :default-active="'/index'"
      router
      mode="horizontal"
      background-color=#6495ED
      text-color=#6A5ACD
      active-text-color=#87CEFA
      style="min-width: 1300px">
    <!--启用router后，激活导航时以index作为path进行路由跳转-->
    <!--通过v-for把navList渲染为一组<el-menu-item>元素，即导航栏内容-->
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>

    <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>
    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>
    <span style="position: fixed;padding-top: 15px;right: 46%;font-size: 20px;font-weight: bold">图 书 管 理 系 统</span>
  </el-menu>
</template>

<script>
export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [
        {name: '/index', navItem: '首页'},
        {name: '/library', navItem: '图书管理'},
        {name: '/user', navItem: '读者管理'},
        {name: '/log', navItem: '借还日志'}
      ]
    }
  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>

