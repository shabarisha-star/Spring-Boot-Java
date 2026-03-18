import { useState } from "react";

function ListPrime() {
  const [number, setNumber] = useState("");
  const [result, setResult] = useState([]);

  const isPrimeCheck = (n) => {
    if (n <= 1) return false;

    for (let i = 2; i < n; i++) {
      if (n % i === 0) return false;
    }

    return true;
  };

  const checkPrime = () => {
    const numbers = number.split(" "); 

    const output = numbers.map((num) => {
      const n = Number(num);

      return `${n} ${isPrimeCheck(n) ? "Prime" : "Not Prime"}`;
    });

    setResult(output);
  };

  return (
    <div >
      <h2>Prime Checker</h2>

      <input
        type="text"
        value={number}
        onChange={(e) => setNumber(e.target.value)}
        placeholder="Enter numbers (e.g. 1 2 3 4)"
      />

      <button onClick={checkPrime}>Check</button>

      <div>
        {result.map((res, index) => (
          <p key={index}>{res}</p>
        ))}
      </div>
    </div>
  );
}

export default ListPrime;