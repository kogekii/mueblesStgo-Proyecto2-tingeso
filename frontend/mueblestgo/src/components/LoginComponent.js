import  { Navigate } from 'react-router-dom'
import React from "react";
import LoginService from "../service/LoginService";
class LoginComponent extends React.Component {
  constructor(context) {
    super(context);
    this.state = {
      username: "",
      password: "",
      loged: false,
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
  init(){
    if (this.state.loged){
        return (<Navigate to="/"/>)
    }
    return (<h1>Login</h1>)
  }
  render() {
    return (
      <div>
        {this.init()}
        <form onSubmit={this.handlelogin}>
          <input
            type="text"
            value={this.state.username}
            name="username"
            placeholder="username"
            onChange={({ target }) => this.setState({ username: target.value })}
          />
          <input
            type="password"
            value={this.state.password}
            name="password"
            placeholder="password"
            onChange={({ target }) => this.setState({ password: target.value })}
          />
          <button>login</button>
        </form>
        
      </div>
    );
  }
}

export default LoginComponent;
