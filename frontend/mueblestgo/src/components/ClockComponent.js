import React from "react";
import ClockService from "../service/ClockService";
import axios from "axios";
import Table from "react-bootstrap/Table";
import {Navbar} from '../components/navbar'
import Sidebar from "./Sidebar";

class ClockComponent extends React.Component {
  state = {
    file: null,
    intimes: ["a"],
    outtimes: [],
  };
  handleFile(e) {
    let file = e.target.files[0];
    this.setState({ file: file });
  }

  handleUpload(e) {
    let file = this.state.file;
    let formdata = new FormData();
    formdata.append("file", file);
    axios({
      url: "http://localhost:8002/clock/readclock",
      method: "POST",
      data: formdata,
    });
  }

  componentDidMount() {
    ClockService.getallIn().then((res) => this.setState({ intimes: res.data }));
    ClockService.getallOut().then((res) =>
      this.setState({ outtimes: res.data })
    );
  }

  render() {
    return (
      <div className="row">
        <div className="col-2">
          <Sidebar/>
        </div>
        <div className="col-10">
        <h1>Control Clock</h1>
        <div>
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
          <h1>In Times</h1>
          <div className="scrollable">
            <Table striped bordered hover variant="dark">
              <thead>
                <tr>
                  <td>Rut</td>
                  <td>Day</td>
                  <td>Time</td>
                  <td>Extra</td>
                  <td>Late</td>
                </tr>
              </thead>
              <tbody>
                {this.state.intimes.map((intimes) => (
                  <tr key={intimes.index}>
                    <td>{intimes.rutEmployee}</td>
                    <td>{intimes.day}</td>
                    <td>{intimes.time}</td>
                    <td>{intimes.extra}</td>
                    <td>{intimes.late}</td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </div>
          <h1>Out Times</h1>
          <div className="scrollable">
            <Table  responsive bordered hover variant="dark">
              <thead>
                <tr>
                  <td>Rut</td>
                  <td>Day</td>
                  <td>Time</td>
                  <td>Extra</td>
                  <td>Late</td>
                </tr>
              </thead>
              <tbody>
                {this.state.outtimes.map((outtimes) => (
                  <tr key={outtimes.index}>
                    <td>{outtimes.rutEmployee}</td>
                    <td>{outtimes.day}</td>
                    <td>{outtimes.time}</td>
                    <td>{outtimes.extra}</td>
                    <td>{outtimes.late}</td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </div>
        </div>
        </div>
      </div>
    );
  }
}

export default ClockComponent;
