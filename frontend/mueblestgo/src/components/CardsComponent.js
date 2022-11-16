import React from "react";

function CardNormal(props) {
  return (
    <div className="card cartanormal">
      <div className="card-body">
        <h5 className="card-title"><i class={props.icon}></i> {props.name}</h5>
        <p className="card-text">{props.value}</p>
      </div>
    </div>
  );
}

function CardBlack(props) {
  return (
    <div className="card cartablack">
      <div className="card-body">
        <h5 className="card-title"><i class="bi bi-cash-stack"></i> {props.name}</h5>
        <h1 className="card-text">${props.value}</h1>
      </div>
    </div>
  );
}

function CardLarge(props) {
  return (
    <div className="card cartalarga">
      <div className="card-body">
        <h5 className="card-title"><i class="bi bi-cash-coin"></i> {props.name}</h5>
        <h1 className="card-text">{props.value}</h1>
      </div>
    </div>
  );
}

export default {CardNormal, CardLarge, CardBlack};
