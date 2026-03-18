import { useState } from "react";
import "./Evaluation.css";

function Evaluation() { 
    const [expression, setExpression] = useState("");
    const [result, setResult] = useState(0);

    const calculate = () => {
        try {
            setResult(eval(expression));
        } catch (error) {
            setResult("Invalid expression");
        }
    };
    return (
        <>
            <input
                type="text"
                placeholder="(5+10*8)"
                value={expression}
                onChange={(e) => setExpression(e.target.value)}
            />
            <button onClick={calculate}>Calculate</button>
            <h1>{result}</h1>
        </>
    );
}

export default Evaluation;