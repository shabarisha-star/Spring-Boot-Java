import { useState } from "react";
import TrueorFalse from "./component/TrueorFalse";
import Guess from "./component/guess";
import Grading from "./component/Grading";
import ListDisplay from "./component/ListDisplay";
import Prime from "./component/Prime";
import ListPrime from "./component/ListPrime";

function App(){
  const [count,setCount]=useState(0);

  const increamentCount= () =>{
    setCount(count+1);
  };

  const decreamentCount= () =>{
    setCount(count-1);
  };

  return(
    <div style={{ 
      fontFamily:"sans-serif",
       backgroundColor:"#87CEEB",
       color: "white",
      
       }}>
      <h2>Counter app</h2>
      <p>count:{count}</p>
      <button onClick={increamentCount}>count+1</button>
      <button onClick={decreamentCount}>count-1</button> 
      <TrueorFalse/> 
      <Guess/>
      <Grading/>
      <ListDisplay/>
      <Prime/>
      <ListPrime/>
    </div>
  );
  
  

}
export default App;