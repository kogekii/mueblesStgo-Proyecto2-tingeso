import { Navigate } from 'react-router-dom'
import React from "react";
import LoginService from "../service/LoginService";
class LoginComponent extends React.Component {
  constructor(context) {
    super(context);
    this.state = {
      username: "",
      password: "",
      role: "",
      logeed: false,
    };
  }
  handlelogin = async (event) => {
    event.preventDefault();
    const token = await LoginService.login(
      this.state.username,
      this.state.password
    );

    LoginService.savetoken(token);
    this.setState({ username: "" });
    this.setState({ password: "" });
    this.setState({ loged: true });

  };
  init() {
    if (this.state.loged) {
      return (<Navigate to="/" />)
    }
    return (<h1>Login</h1>)
  }
  render() {
    return (
      <div>
        {this.init()}
        <div className="card cartalogin">
          <div className="card-body">
            <h1 className="card-title">Login</h1>
            <form onSubmit={this.handlelogin}>
              <div>
                <label className='form-label mb-3'>Usuario</label>
                <input
                className='form-control'
                type="text"
                value={this.state.username}
                name="username"
                placeholder="username"
                onChange={({ target }) => this.setState({ username: target.value })}
              />
              </div>
              <div className='mb-3'>
              <label className='form-label mb-3'>Contraseña</label>
              <input
              className='form-control'
                type="password"
                value={this.state.password}
                name="password"
                placeholder="password"
                onChange={({ target }) => this.setState({ password: target.value })}
              />
              </div>
              
              <button className='btn btn-primary'>login</button>
            </form>
          </div>
        </div>
      </div>

    );
  }
}

export default LoginComponent;
