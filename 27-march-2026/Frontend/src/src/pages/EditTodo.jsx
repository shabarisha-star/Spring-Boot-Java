import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getTodoById, updateTodo } from "../services/todoService";

export default function EditTodo() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  // fetch existing todo
  useEffect(() => {
    const fetchTodo = async () => {
      try {
        const data = await getTodoById(id);
        setTitle(data.title);
        setDescription(data.description);
      } catch (error) {
        console.log(error);
      }
    };
    fetchTodo();
  }, [id]);

  // update todo
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await updateTodo(id, { title, description });
      alert("✅ Todo Updated");
      navigate("/");
    } catch (error) {
      console.log(error);
      alert("❌ Update failed");
    }
  };

  return (
    <div style={container}>
      <form onSubmit={handleSubmit} style={form}>
        <h2 style={titleStyle}>✏️ Edit Todo</h2>

        <div style={inputGroup}>
          <label style={label}>Title</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
            style={input}
          />
        </div>

        <div style={inputGroup}>
          <label style={label}>Description</label>
          <input
            type="text"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
            style={input}
          />
        </div>

        <button type="submit" style={button}>
          Update Todo
        </button>

        <button
          type="button"
          onClick={() => navigate("/")}
          style={backBtn}
        >
          ⬅ Back
        </button>
      </form>
    </div>
  );
}

//////////////////////////////////////////////////
// 🎨 STYLES
//////////////////////////////////////////////////

const container = {
  height: "100vh",
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  background: "linear-gradient(135deg, #ff9a9e, #fad0c4)",
  fontFamily: "Arial, sans-serif",
};

const form = {
  background: "#fff",
  padding: "30px",
  borderRadius: "15px",
  width: "350px",
  boxShadow: "0 8px 25px rgba(0,0,0,0.2)",
  display: "flex",
  flexDirection: "column",
  gap: "15px",
};

const titleStyle = {
  textAlign: "center",
  color: "#333",
};

const inputGroup = {
  display: "flex",
  flexDirection: "column",
};

const label = {
  fontWeight: "bold",
  marginBottom: "5px",
};

const input = {
  padding: "10px",
  borderRadius: "8px",
  border: "1px solid #ccc",
  fontSize: "14px",
};

const button = {
  padding: "12px",
  background: "linear-gradient(135deg, #667eea, #764ba2)",
  color: "#fff",
  border: "none",
  borderRadius: "8px",
  fontSize: "16px",
  fontWeight: "bold",
  cursor: "pointer",
};

const backBtn = {
  padding: "10px",
  background: "#ddd",
  border: "none",
  borderRadius: "8px",
  cursor: "pointer",
};