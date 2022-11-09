import axios from 'axios'


class EmployeeService {
    baseUrl = "http://localhost:8003/employee/";
    getAll(token) {
        return axios.get(this.baseUrl + "getall", {
            headers: {
                'Authorization': 'Bearer ' + token
            }
        }).then(res => res);

    }
    }

export default new EmployeeService()