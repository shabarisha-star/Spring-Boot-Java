import { useState } from "react";

function Guess() {

  const [guess, setGuess] = useState();
  const [result, setResult] = useState("");

  const check = () => {
    const hardNumber=6;
    if (hardNumber == guess) {
      setResult("Correct");
    } else {
      setResult("Wrong");
    }
  };

  return (
    <>
    <div>
    <h2>Guess the Number</h2>
      <input
        type="number"
        onChange={(e) => setGuess(e.target.value)}
      />

      <button onClick={check}>Check</button>
      <h3>{result}</h3>
      </div>
    </>
  );
}

export default Guess;
