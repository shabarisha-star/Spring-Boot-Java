import { useState } from "react";

function Prime() {
  const [number, setNumber] = useState(""); 
  const [result, setResult] = useState("");

  const handlePrime = () => {
    const num = parseInt(number);
    if (isNaN(num) || num < 1) {
      setResult("Enter a valid positive number");
      return; 
    }

    let isPrime = true;
    if (num === 1) {
      isPrime = false;
    }
    for (let i = 2; i <= Math.sqrt(num); i++) {
      if (num % i === 0) {
        isPrime = false;
        break;
      }
    }

    setResult(isPrime ? `${num} is Prime` : `${num} is Not Prime`);
  };

  return (
    <>
      <h2>Prime Checker</h2>
      <input
        type="number"
        placeholder="Enter Number"
        value={number}
        onChange={(e) => setNumber(e.target.value)}
      />
      <br />
      <button onClick={handlePrime}>Submit</button>
      <p>Result: {result}</p>
    </>
  );
}

export default Prime;