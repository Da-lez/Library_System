<template>
    <div id="bg">
    <el-form autocomplete="on" :model="loginForm" ref="loginForm" :rules="rules" class="login-container"
             label-position="left"
             label-width="0px" v-loading="loading">
      <h3 class="login_title">图书管理系统登录</h3>
      <el-form-item prop="username">
        <el-input name="username" type="text" v-model="loginForm.username"
                  auto-complete="off" placeholder="请输入用户名">
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input name="password" type="password" v-model="loginForm.password"
                  auto-complete="off" placeholder="请输入密码">
        </el-input>
      </el-form-item>
      <el-form-item style="width: 100%;margin-bottom: 60px">
        <el-button type="primary" style="width: 60%;background: #505458;border: none" v-on:click="login">登录</el-button>
        <router-link to="register">
          <el-button type="primary" style="width:60%;background: #505458;border: none">注册</el-button>
        </router-link>
      </el-form-item>
    </el-form>
    </div>
</template>
<script>
export default {
  data() {
    return {
      rules: {
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      checked: true,
      loginForm: {
        username: 'admin',
        password: '123'
      },
    }
  },
  methods: {
    login() {
      this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(resp => {
            if (resp.data.code === 200) {
              this.$router.replace({path: '/index'})
            } else {
              this.$alert(resp.data.message, '提示', {
                message: '请输入正确的用户名和密码',
                confirmButtonText: '确定'
              })
            }
          })
          .catch(failResponse => {
          })
    }
  }
}
</script>
<style>
#bg {
  background: url("../assets/bg1.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: 0;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
