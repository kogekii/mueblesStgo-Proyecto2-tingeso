import React from "react";
import SalaryService from "../service/SalaryService";
import Table from "react-bootstrap/Table";
import Sidebar from "./Sidebar";
class SalaryComponent extends React.Component{
    constructor(){
        super();
        this.state = {
            salary:[]
        }
    }

    componentDidMount(){
        SalaryService.getall().then(res => this.setState({salary: res.data}));
    }
    recalcular(){
        SalaryService.calculate();
    }
    render(){
        return(
            <div className="row">
            <div className="col-2">
                <Sidebar/>
            </div>
            <div className="col-10">
            <h1 className="text-center">Salary</h1>
            <Table striped bordered hover variant="dark">
                <thead>
                    <tr>
                        <td> Rut</td>
                        <td> Name</td>
                        <td> Surname</td>
                        <td> Category</td>
                        <td> Hiring Day</td>
                        <td> Base Salary</td>
                        <td> extra</td>
                        <td>Atrazos</td>
                        <td>Iniacistencia</td>
                        <td>Bono Antiguedad</td>
                        <td>Salario Final</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.salary.map(
                            salary => 
                            (<tr key={salary.index}>
                                <td>{salary.rutEmployee}</td>
                                <td>{salary.nameEmployee}</td>
                                <td>{salary.surnameEmployee}</td>
                                <td>{salary.category}</td>
                                <td>{salary.hiringDay}</td>
                                <td>{salary.baseSalary}</td>
                                <td>{salary.extra}</td>
                                <td>{salary.late}</td>
                                <td>{salary.inasistence}</td>
                                <td>{salary.bonoAntiguedad}</td>
                                <td>{salary.finalSalary}</td>
                            </tr>)
                        )
                    }
                </tbody>
            </Table>
            <button className="btn btn-primary" onClick={this.recalcular}>Recalcular</button>
            </div>
        </div>
        )
    }
}

export default SalaryComponent