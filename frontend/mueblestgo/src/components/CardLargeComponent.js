import React from "react";

function CardLarge(props) {
  return (
    <div class="card cartalarga">
      <div class="card-body">
        <h5 class="card-title">{props.name}</h5>
        <h1 class="card-text">{props.value}</h1>
      </div>
    </div>
  );
}

export default CardLarge;