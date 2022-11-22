import React from "react";
import { Navbar } from "../components/navbar";
import axios from "axios";
import EmployeeService from "../service/EmployeeService";
import Table from "react-bootstrap/Table";
import Sidebar from "./Sidebar";
class EmployeeComponent extends React.Component {
  constructor() {
    super();
    this.state = {
      employee: [],
    };
  }
  componentDidMount() {
    EmployeeService.getAll(localStorage.getItem("token")).then((response) =>
      this.setState({ employee: response.data })
    );
  }
  handleFile(e) {
    let file = e.target.files[0];
    this.setState({ file: file });
  }
  handleUpload(e) {
    let file = this.state.file;
    let formdata = new FormData();
    formdata.append("file", file);
    axios({
      url: "http://localhost:8003/leercorreo",
      method: "POST",
      data: formdata,
    });
  }
  render() {
    return (
      <div className="row">
        <div className="col-2">
          <Sidebar />
        </div>
        <div className="col-10">
          
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
              {this.state.employee.map((employee) => (
                <tr key={employee.index}>
                  <td>{employee.rutEmployee}</td>
                  <td>{employee.nameEmployee}</td>
                  <td>{employee.surnameEmployee}</td>
                  <td>{employee.categoryEmployee}</td>
                  <td>{employee.birthday}</td>
                  <td>{employee.hiringday}</td>
                  <td>{employee.office}</td>
                </tr>
              ))}
            </tbody>
          </Table>
          <form>
            <label></label>
            <input
              type="file"
              name="file"
              onChange={(e) => this.handleFile(e)}
            ></input>
            <button type="submit" onClick={(e) => this.handleUpload(e)}>
              agregar
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default EmployeeComponent;
