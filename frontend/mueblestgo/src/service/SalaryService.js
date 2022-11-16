import axios from "axios";

class SalaryService{
    baseUrl = "http://localhost:8004/salary/";
    getall(){
        return axios.get(this.baseUrl + "getall");
    }

    getsalary(rut){
        return axios.get(this.baseUrl + "getsalary/" + rut);
    }
}

export default new SalaryService()