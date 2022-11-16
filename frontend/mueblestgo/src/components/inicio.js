import React from "react";
// import {Navbar} from '../components/navbar'
// import LoginService from "../service/LoginService";
import CardBlack from "./CardBlackComponent";
import CardLarge from "./CardLargeComponent";
import Sidebar from "./Sidebar";
import CardNormal from "./CardNormalComponemt";
import Infobar from "./Infobar";
import SalaryService from "../service/SalaryService";

class Inicio extends React.Component{
    constructor(){
        super();
        this.state = {
            salary:[],
            employee:""
        }

    }
    componentDidMount(){
        SalaryService.getsalary("11.234.123-6").then(res=> {
            this.setState({salary: res.data});
            this.setState({employee: res.data.nameEmployee});
        });
    }

    render(){
        return(
            <div className='row'>
          <div className='col-2 nopadding'>
            <Sidebar/>
          </div>
          <div className='col-10 nopadding'>
            <Infobar/>
            <div className='row'>
              <div className='col-4'>
                <CardNormal name="Salario Base" value={"$"+this.state.salary.baseSalary}/>
              </div>
              <div className='col-4'>
              <CardNormal name="Categoria" value={this.state.salary.category}/>
              </div>
              <div className='col-4'>
              <CardNormal name="######" value="$$$$"/>
              </div>
            </div>
            <div className='row'>
              <div className='col-8'>
                <CardBlack name="Sueldo" value={this.state.salary.finalSalary}/>
              </div>
              <div className='col-4'>
                <CardLarge name="Extra" value={this.state.salary.extra}/>
              </div>
            </div>
          </div>
        </div>
            
        )
    }
}

export default Inicio