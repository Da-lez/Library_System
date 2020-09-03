<template>
  <div>
    <el-row style="margin: 18px 0px 0px 18px "></el-row>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
          :data="logs.filter(data => !search || data.date==search ||data.book_id==search||data.status==='借书')"
          style="width: 100%"
          :max-height="tableHeight"
          :default-sort="{prop:'date',order: 'descending'}"
          :row-class-name="tableRowName">
        <el-table-column
            prop="date"
            label="日期"
            width="100">
        </el-table-column>
        <el-table-column
            prop="user_id"
            label="用户id"
            width="100">
        </el-table-column>
        <el-table-column
            prop="book_id"
            label="书号"
            width="100">
        </el-table-column>
        <el-table-column
            prop="status"
            label="操作"
            width="150">
        </el-table-column>
        <el-table-column>
          <template slot="header" slot-scope="scope">
            <el-select v-model="value" placeholder="查看借出或归还">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
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
  name: 'Log',
  data() {
    return {
      options: [{
        value: '选项1',
        label: '借出日志'
      }, {
        value: '选项2',
        label: '归还日志'
      }
      ],
      value: '',
      logs: [],
      search: ''
    }
  },
  mounted: function () {
    this.listLogs()
  },
  computed: {
    tableHeight() {
      return window.innerHeight - 320
    }
  },

  methods: {

    tableRowName(object) {
      if (object.row.status === "借书") {
        return 'warning-row';
      } else {
        return 'success-row';
      }
    },
    listLogs() {
      var _this = this
      this.$axios.get('/log').then(resp => {
        if (resp && resp.status === 200) {
          _this.logs = resp.data
        }
      })
    },
  }
}
</script>

<style scoped>

</style>
