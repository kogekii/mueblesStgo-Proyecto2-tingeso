import axios from "axios";

class SalaryService{
    baseUrl = "http://localhost:8080/salary/";
    getall(){
        return axios.get(this.baseUrl + "getall");
    }
}

export default new SalaryService()