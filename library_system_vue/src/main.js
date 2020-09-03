import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 前端请求默认发送到 http://localhost:8080/managebooks
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8080/managebooks'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false //阻止vue 在启动时生成生产提示。

Vue.use(ElementUI)
//创建一个 Vue 对象
new Vue({
  render: h => h(App),
  router,
}).$mount('#app')

