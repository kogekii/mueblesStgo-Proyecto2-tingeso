import React from "react";
import { Link } from "react-router-dom";

class Sidebar extends React.Component{
    render(){
        return(
            <div className="sidebar" >
                <Link to="/"><h1>MueblesStgo</h1></Link>
                <Link className="hov" to="/employee"><i class="bi bi-people-fill"></i> Empleados</Link>
                <Link className="hov" to="/clock"><i class="bi bi-clock"></i> Reloj Control</Link>
                <Link className="hov" to="/salary"><i class="bi bi-envelope"></i> Salario</Link>
            </div>
        )
    }
}

export default Sidebar;
