<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
        title="添加/修改图书"
        :visible.sync="dialogFormVisible"
        @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="书号" :label-width="formLabelWidth" prop="id">
          <el-input v-model="form.id" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="书名" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="formLabelWidth" prop="author">
          <el-input v-model="form.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" :label-width="formLabelWidth" prop="press">
          <el-input v-model="form.press" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="URL"></el-input>
        </el-form-item>
        <el-form-item label="藏书量" :label-width="formLabelWidth" prop="total">
          <el-input type="text" v-model="form.total" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="借出数" :label-width="formLabelWidth" prop="lent">
          <el-input  type="text" v-model="form.lent" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'EditForm',
  data () {
    return {
      dialogFormVisible: false,
      form: {
        id: '',
        cover: '',
        title: '',
        author: '',
        press: '',
        total: '',
        lent: '0'
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    clear () {
      this.form = {
        id: '',
        cover: '',
        title: '',
        author: '',
        press: '',
        total: '',
        lent: '0',
      }
    },
    onSubmit () {
      this.$axios
          .post('/books', {
            id: this.form.id,
            cover: this.form.cover,
            title: this.form.title,
            author: this.form.author,
            press: this.form.press,
            total: this.form.total,
            lent: this.form.lent
          }).then(resp => {
        if (resp && resp.status === 200) {
          this.dialogFormVisible = false
          this.$emit('onSubmit')
        }
      })
    }
  }
}
</script>

<style scoped>
.el-icon-circle-plus-outline {
  margin: 50px 0 0 20px;
  font-size: 100px;
  float: left;
  cursor: pointer;
}
</style>


