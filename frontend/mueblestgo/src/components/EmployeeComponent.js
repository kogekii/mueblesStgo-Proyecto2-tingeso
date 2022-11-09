import React from "react";
import EmployeeService  from "../service/EmployeeService";
import Table from "react-bootstrap/Table";
class EmployeeComponent extends React.Component {
    constructor(){
        super();
        this.state = {
            employee:[],
        }
    }
    componentDidMount(){
        EmployeeService.getAll(localStorage.getItem('token')).then((response) => this.setState({employee:response.data}));
        
    }
    render(){
        return (
            <div>
                <h1 className="text-center">Employees List</h1>
                <Table striped bordered hover variant="dark">
                    <thead>
                        <tr>
                            <td> Employeer Rut</td>
                            <td> Employeer Name</td>
                            <td> Employeer Surname</td>
                            <td> Employeer Category</td>
                            <td> Employeer birthday</td>
                            <td> Employeer Hiringday</td>
                            <td> Employeer Office</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.employee.map(
                                employee => 
                                (<tr key={employee.index}>
                                    <td>{employee.rutEmployee}</td>
                                    <td>{employee.nameEmployee}</td>
                                    <td>{employee.surnameEmployee}</td>
                                    <td>{employee.categoryEmployee}</td>
                                    <td>{employee.birthday}</td>
                                    <td>{employee.hiringday}</td>
                                    <td>{employee.office}</td>
                                </tr>)
                            )
                        }
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default EmployeeComponent