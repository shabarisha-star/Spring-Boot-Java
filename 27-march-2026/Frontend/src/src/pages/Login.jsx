import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function Auth() {
  const [isLogin, setIsLogin] = useState(true);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const url = isLogin
      ? "http://localhost:1010/auth/login"
      : "http://localhost:1010/auth/register";

    try {
      const res = await axios.post(url, {
        username,
        password,
      });

      if (isLogin) {
        localStorage.setItem("token", res.data.token);
        alert("Login successful ✅");
        navigate("/");
      } else {
        alert("Registered successfully ✅");
        setIsLogin(true);
      }
    } catch (err) {
      alert("Error: " + (err.response?.data || "Something went wrong"));
    }
  };

  return (
    <div
      style={{
        height: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        background: "linear-gradient(135deg, #667eea, #764ba2)",
      }}
    >
      <div
        style={{
          background: "#fff",
          padding: "30px",
          borderRadius: "10px",
          width: "300px",
          boxShadow: "0 5px 15px rgba(0,0,0,0.2)",
          textAlign: "center",
        }}
      >
        <h2>{isLogin ? "Login" : "Register"}</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Username"
            required
            onChange={(e) => setUsername(e.target.value)}
            style={{
              width: "100%",
              padding: "10px",
              margin: "10px 0",
              borderRadius: "5px",
              border: "1px solid #ccc",
            }}
          />

          <input
            type="password"
            placeholder="Password"
            required
            onChange={(e) => setPassword(e.target.value)}
            style={{
              width: "100%",
              padding: "10px",
              margin: "10px 0",
              borderRadius: "5px",
              border: "1px solid #ccc",
            }}
          />

          <button
            type="submit"
            style={{
              width: "100%",
              padding: "10px",
              background: "#667eea",
              color: "#fff",
              border: "none",
              borderRadius: "5px",
              cursor: "pointer",
              fontWeight: "bold",
            }}
          >
            {isLogin ? "Login" : "Register"}
          </button>
        </form>

        <p style={{ marginTop: "15px" }}>
          {isLogin ? "Don't have an account?" : "Already have an account?"}
          <span
            onClick={() => setIsLogin(!isLogin)}
            style={{
              color: "#667eea",
              cursor: "pointer",
              marginLeft: "5px",
              fontWeight: "bold",
            }}
          >
            {isLogin ? "Register" : "Login"}
          </span>
        </p>
      </div>
    </div>
  );
}