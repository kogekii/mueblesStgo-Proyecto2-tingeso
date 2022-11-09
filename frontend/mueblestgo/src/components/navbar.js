import React from "react";
import { Link } from "react-router-dom";

export const Navbar = () => {
  return (
    <div className="row justify-content-center" id="navbar">
      <Link to="/" className="col-3"><p className="text-center">Inicio</p></Link>
      <Link to="/employee" className="col-3"><p className="text-center">Empleados</p></Link>
      <Link to="/salary" className="col-3"><p className="text-center">Sueldos</p></Link>
      <Link to="/clock" className="col-3"><p className="text-center">Reloj</p></Link>
    </div>
  );
};