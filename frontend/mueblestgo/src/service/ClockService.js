import axios from "axios";

class ClockService {
    baseUrl = "http://localhost:8002/clock/";
    getallIn(){
       return axios.get(this.baseUrl + "getallintimes");
    }
    getallOut(){
        return axios.get(this.baseUrl + "getallouttimes");
     }

}

export default new ClockService()