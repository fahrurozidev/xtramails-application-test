<template>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
                <h4>Add Students</h4>
            </div>
            <div class="card-body">
                <div class="mb-3">
                    <label for="">First Name</label>
                    <input type="text" v-model="model.student.firstName" name="firstName" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="">Last Name</label>
                    <input type="text" v-model="model.student.lastName" name="lastName" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="">Date Of Birth</label>
                    <input type="date" v-model="model.student.dob" name="dob" class="form-control">
                </div>
                <div class="mb-3">
                    <button type="button" class="btn btn-primary" @click="saveStudent">Save</button>
                    <RouterLink type="button"  to="/students" class="btn btn-danger"> Cancel </RouterLink>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'studentCreate',
    data(){
        return {
            model: {
                student:{
                    firstName: '',
                    lastName: '',
                    dob: ''
                }
            }
        }
    },
    methods:{
        saveStudent(){
            axios.post('http://localhost:8080/api/student', this.model.student).then(res=>{
                console.log(res.data)
                alert('data successfully inserted');
                this.model.student = {
                    firstName: '',
                    lastName: '',
                    dob: ''
                }
                
                this.$router.push('/students')
            })
            .catch(function(error){
                if(error.response){
                    console.log(error.response.data);
                    console.log(error.response.status);
                    console.log(error.response.headers)
                }else if(error.request){
                    console.log(error.request);
                }else{
                    console.log('Error', error.message)
                }
            })
        }
    }
}
</script>