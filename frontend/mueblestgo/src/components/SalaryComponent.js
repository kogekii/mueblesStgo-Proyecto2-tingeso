import React from "react";
import SalaryService from "../service/SalaryService";
import Table from "react-bootstrap/Table";
import {Navbar} from '../components/navbar'
class SalaryComponent extends React.Component{
    constructor(){
        super();
        this.state = {
            salary:[]
        }
    }

    componentDidMount(){
        SalaryService.getall().then(res => this.setState({salary: res.data}));
        SalaryService.getsalary("11.234.123-6").then(res=> res.data);
    }

    render(){
        return(
            <div>
                <Navbar/>
            <h1 className="text-center">Salary</h1>
            <Table striped bordered hover variant="dark">
                <thead>
                    <tr>
                        <td> Rut</td>
                        <td> Name</td>
                        <td> Surname</td>
                        <td> Category</td>
                        <td> Base Salary</td>
                        <td> extra</td>
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
                                <td>{salary.baseSalary}</td>
                                <td>{salary.extra}</td>
                            </tr>)
                        )
                    }
                </tbody>
            </Table>
        </div>
        )
    }
}

export default SalaryComponent