<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h4>
          Students
          <RouterLink to="/students/create" class="btn btn-primary float-end"
            >Add Student</RouterLink
          >
        </h4>
      </div>
      <div class="card-body">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>NIM</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Birth Day</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody v-if="this.students.length > 0">
            <tr v-for="(student, index) in this.students" :key="index">
              <td>{{ student.id }}</td>
              <td>{{ student.firstName }}</td>
              <td>{{ student.lastName }}</td>
              <td>{{ student.dob }}</td>
              <td>
                <RouterLink :to="{path: '/students/'+student.id+'/edit'}" class="btn btn-success"> Edit </RouterLink>
                <RouterLink type="button" @click="deleteStudent(student.id)" to="/students" class="btn btn-danger"> Delete </RouterLink>
              </td>
            </tr>
          </tbody>
          <tbody v-else>
            <tr>
                <td colspan="5">Loading...</td>
            </tr>

          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "students",
  data() {
    return {
      students: [],
    };
  },
  mounted() {
    this.getStudents();
  },
  methods: {
    getStudents() {
      axios.get("http://localhost:8080/api/student").then((res) => {
        this.students = res.data;
        console.log(this.students);
      });
    },
    deleteStudent(studentId){
        axios.delete('http://localhost:8080/api/student/'+studentId).then(res=>{
            console.log(res.data)
            this.getStudents();
        })
    }
  },
};
</script>
