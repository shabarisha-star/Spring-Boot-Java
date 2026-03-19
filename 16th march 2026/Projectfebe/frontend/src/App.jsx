import { useState } from "react";
import axios from "axios";

function App() {
  const [a, setA] = useState("");
  const [b, setB] = useState("");
  const [result, setResult] = useState(null);

  const handleAdd = () => {
    axios
      .get(`http://localhost:8080/add?a=${a}&b=${b}`)
      .then((res) => {
        setResult(res.data.result);
      })
      .catch((err) => console.log(err));
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Addition App</h1>

      <input
        type="number"
        placeholder="Enter A"
        value={a}
        onChange={(e) => setA(e.target.value)}
      />

      <input
        type="number"
        placeholder="Enter B"
        value={b}
        onChange={(e) => setB(e.target.value)}
      />

      <br /><br />

      <button onClick={handleAdd}>Add</button>

      {result !== null && <h2>Result: {result}</h2>}
    </div>
  );


  // const [data, setData] = useState(null);

  // useEffect(() => {
  //   axios
  //     .get("http://localhost:8080/hello")
  //     .then((res) => {
  //       console.log(res.data);
  //       setData(res.data);
  //     })
  //     .catch((err) => console.log(err));
  // }, []);

  // return (
  //   <div>
  //     <h1>{data?.message}</h1>
  //     <p>{data?.description}</p>
  //   </div>
  // );
}

export default App;