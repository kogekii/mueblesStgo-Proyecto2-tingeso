import axios from "axios";

class SalaryService{
    baseUrl = "http://localhost:8004/salary/";
    getall(){
        return axios.get(this.baseUrl + "getall/",{
            headers:{
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        });
    }

    getsalary(rut){
        return axios.get(this.baseUrl + "getsalary/" + rut,{
            headers:{
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        });
    }

    calculate(){
        return axios.get(this.baseUrl + "calculatesalary");
    }
}

export default new SalaryService()