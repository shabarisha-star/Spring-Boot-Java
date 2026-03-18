import { useState } from "react";

import "./Calc.css";

function Calculator() {
  const [num1, setNum1] = useState(0);
  const [num2, setNum2] = useState(0);
  const [res, setRes] = useState(0);

  const add = () => {
    setRes(Number(num1) + Number(num2));
  };

  const sub = () => {
    setRes(Number(num1) - Number(num2));
  };

  const mult = () => {
    setRes(Number(num1) * Number(num2));
  };

  const div = () => {
    setRes(Number(num1) / Number(num2));
  };

  return (
    <div className="calculator-container">
      <input type="number" value={num1} onChange={(e) => setNum1(e.target.value)} />
      <input type="number" value={num2} onChange={(e) => setNum2(e.target.value)} />
      <button onClick={add}>+</button>
      <button onClick={sub}>-</button>
      <button onClick={mult}>*</button>
      <button onClick={div}>/</button>
      <h2>Result: {res}</h2>
    </div>
  );
}

export default Calculator;