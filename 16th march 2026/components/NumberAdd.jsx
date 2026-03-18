import { useState } from "react";
import "./NumberAdd.css";

function NumberAdd()
 {
    const [num1, setNum1] = useState(0);
    const [num2, setNum2] = useState(0);
    const [result, setResult] = useState(0);

    const handleAdd = () => {
        setResult(Number(num1) + Number(num2));
    };
  return (
    <>
        <input
            type="number"
            value={num1}
            onChange={(e) => setNum1(Number(e.target.value))}
        />
        <input
            type="number"
            value={num2}
            onChange={(e) => setNum2(Number(e.target.value))}
        />
        <button onClick={handleAdd}>Add</button>
        <h1>{result}</h1>
    </>
  );
}

export default NumberAdd;