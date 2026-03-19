import { useState } from "react";

function TrueorFalse() {
  const [count, setCount] = useState(true);

  const toggleValue = () => {
    setCount(!count);
  };

  return (
    <div >
        <h2>Upadate true or false</h2>
     {count && <div>true</div>} 
     {!count && <div>false</div>}
      <button onClick={toggleValue}>update state</button>
    </div>
  );
}

export default TrueorFalse;