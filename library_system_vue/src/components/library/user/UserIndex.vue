<template>
  <div>
    <el-dialog
        title="修改用户信息"
        :visible.sync="dialogFormVisible">
      <el-form v-model="selectedUser" style="text-align: left" ref="dataForm">
        <el-form-item label="用户名" label-width="120px" prop="username">
          <label>{{ selectedUser.username }}</label>
        </el-form-item>
        <el-form-item label="姓名" label-width="120px" prop="name">
          <el-input v-model="selectedUser.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" label-width="120px" prop="phone">
          <el-input v-model="selectedUser.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" label-width="120px" prop="password">
          <el-button type="warning" @click="resetPassword(selectedUser.username)">重置密码</el-button>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible=false">取 消</el-button>
        <el-button type="primary" @click="onSubmit(selectedUser)">确 定</el-button>
      </div>
    </el-dialog>
    <el-row style="margin: 18px 10px 10px 18px "></el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
          :data="users.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase())||data.id==search)"
          style="width: 100%"
          :max-height="tableHeight"
          :row-class-name="tableRowName">
        <el-table-column
            prop="username"
            label="用户名"
            width="110">
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            width="110">
        </el-table-column>
        <el-table-column
            prop="id"
            label="用户id"
            width="110">
        </el-table-column>
        <el-table-column
            prop="phone"
            label="手机号"
            width="150">
        </el-table-column>
        <el-table-column
           label="更改">
          <template slot-scope="scope">
            <el-button
                @click="editUser(scope.row)"
                type="text"
                size="small">
              编辑
            </el-button>
            <el-button
                type="text"
                size="small"
                @click="del(scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
        <el-table-column>
          <template slot="header" slot-scope="scope">
            <el-input
                v-model="search"
                size="mini"
                placeholder="输入id或姓名进行搜索"/>
          </template>
        </el-table-column>

      </el-table>
    </el-card>
  </div>
</template>

<style>
.el-table .warning-row {
  background: #F08080;
}

.el-table .success-row {
  background: #90EE90;
}
</style>

<script>

export default {
  name: 'User',
  data() {
    return {
      selectedUser: [],
      users: [],
      dialogFormVisible: false,
      search: ''
    }
  },
  mounted() {
    this.listUsers()
  },
  computed: {
    tableHeight() {
      return window.innerHeight - 320
    }
  },

  methods: {
    clear() {
      this.dialogFormVisible = false;
      this.listUsers()
    },
    tableRowName(object) {
      if (object.row.status==='借书') {
        return 'warning-row';
      } else {
        return 'success-row';
      }
    },
    listUsers() {
      var _this = this
      this.$axios.get('/user').then(resp => {
        if (resp && resp.status === 200) {
          _this.users = resp.data
        }
      })
    },
    onSubmit(user) {
      this.$axios.put('/user', {
        username: user.username,
        name: user.name,
        phone: user.phone,
        date: user.date
      }).then(resp => {
        if (resp && resp.data.code === 200) {
          this.$alert('用户信息修改成功')
          this.dialogFormVisible = false
          // 重新请求用户信息，实现视图更新
          this.listUsers()
        }
      })
    },
    editUser(user) {
      this.dialogFormVisible = true
      this.selectedUser = user
      this.listUsers()
    },
    del(user) {
      this.$axios.put('/user/delete',
          {id: user.id}).then(resp => {
        if (resp && resp.status === 200) {
          this.listUsers()
        }
      })
    },
    resetPassword(username) {
      this.$axios.put('/user/re_pwd', {
        username: username
      }).then(resp => {
        if (resp && resp.status === 200) {
          this.$alert('密码已重置为 123')
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
