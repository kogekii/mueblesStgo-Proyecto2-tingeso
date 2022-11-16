import React from "react";
import { Link } from "react-router-dom";

class Infobar extends React.Component{
    constructor(props){
        super();
        this.state = {
            employee:props.name
        }
    }
    render(){
        return(
            <div className="infobar" >
                <h1>Welcome... {this.state.employee}</h1>
            </div>
        )
    }
}

export default Infobar;