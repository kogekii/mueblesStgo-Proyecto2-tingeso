import React from "react";
import Sidebar from "./components/Sidebar";
import carta from "./components/CardsComponent";
import Infobar from "./components/Infobar";
import SalaryService from "./service/SalaryService";
import { Navigate } from "react-router-dom";
class App extends React.Component{
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
              <carta.CardNormal name="Descuanto" value={this.state.salary.inasistence}/>
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

export default App