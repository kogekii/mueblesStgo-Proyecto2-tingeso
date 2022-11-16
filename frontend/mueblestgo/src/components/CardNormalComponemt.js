import React from "react";

function CardNormal(props) {
  return (
    <div class="card cartanormal">
      <div class="card-body">
        <h5 class="card-title">{props.name}</h5>
        <p class="card-text">{props.value}</p>
      </div>
    </div>
  );
}

export default CardNormal;
