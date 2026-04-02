import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createTodo } from "../services/todoService";

export default function CreateTodo() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await createTodo({ title, description });
      alert("✅ Todo Created Successfully");
      navigate("/"); // 🔥 go to list
    } catch (error) {
      console.log(error);
      alert("❌ Error creating todo");
    }
  };

  return (
    <div style={container}>
      <form onSubmit={handleSubmit} style={form}>
        <h2 style={{ textAlign: "center" }}>Create Todo</h2>

        <input
          type="text"
          placeholder="Enter Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
          style={input}
        />

        <input
          type="text"
          placeholder="Enter Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
          style={input}
        />

        <button type="submit" style={button}>
          Create
        </button>
      </form>
    </div>
  );
}

const container = {
  height: "100vh",
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  background: "linear-gradient(135deg,#667eea,#764ba2)",
};

const form = {
  background: "#fff",
  padding: "30px",
  borderRadius: "10px",
  boxShadow: "0 5px 15px rgba(0,0,0,0.2)",
  width: "300px",
  display: "flex",
  flexDirection: "column",
  gap: "15px",
};

const input = {
  padding: "10px",
  borderRadius: "5px",
  border: "1px solid #ccc",
};

const button = {
  padding: "10px",
  background: "#007bff",
  color: "#fff",
  border: "none",
  borderRadius: "5px",
  cursor: "pointer",
};