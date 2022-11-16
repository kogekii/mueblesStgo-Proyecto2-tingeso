import React from "react";

function CardBlack(props) {
  return (
    <div class="card cartablack">
      <div class="card-body">
        <h5 class="card-title">{props.name}</h5>
        <h1 class="card-text">${props.value}</h1>
      </div>
    </div>
  );
}

export default CardBlack;