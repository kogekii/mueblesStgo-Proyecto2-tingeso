import React from "react";
import Sidebar from "./Sidebar";
import carta from "./CardsComponent";
import Infobar from "./Infobar";
import SalaryService from "../service/SalaryService";
import { Navigate } from "react-router-dom";
class Inicio extends React.Component{
    constructor(){
        super();
        this.state = {
            salary:[],
            isLogged:localStorage.getItem('isLogged')
        }

    }
    componentDidMount(){
        SalaryService.getsalary(localStorage.getItem('rut')).then(res=> {
            this.setState({salary: res.data});
            localStorage.setItem('username', res.data.nameEmployee);
        });
        this.setState({isLogged:localStorage.getItem('isLogged')});
    }

    render(){
      if(this.state.isLogged === "false"){
        return(<Navigate to="/login"/>)
      }
        return(
            <div className='row'>
              {console.log(this.state.isLogged)}
          <div className='col-2 nopadding'>
            <Sidebar/>
          </div>
          <div className='col-10 nopadding'>
            <Infobar/>
            <div className='row'>
              <div className='col-4 nopadding'>
                <carta.CardNormal name="Salario Base" value={"$"+this.state.salary.baseSalary} icon="bi bi-cash-stack"/>
              </div>
              <div className='col-4 nopadding'>
              <carta.CardNormal name="Categoria" value={this.state.salary.category} icon="bi bi-bookmark-fill"/>
              </div>
              <div className='col-4 nopadding'>
              <carta.CardNormal name="######" value="$$$$"/>
              </div>
            </div>
            <div className='row'>
              <div className='col-8 nopadding'>
                <carta.CardBlack name="Sueldo" value={this.state.salary.finalSalary}/>
              </div>
              <div className='col-4 nopadding'>
                <carta.CardLarge name="Extra" value={this.state.salary.extra}/>
              </div>
            </div>
          </div>
        </div>
            
        )
    }
}

export default Inicio