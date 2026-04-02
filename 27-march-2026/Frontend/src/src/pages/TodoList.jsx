import { useEffect, useState } from "react";
import { deleteTodo, getAllTodos } from "../services/todoService";
import { useNavigate } from "react-router-dom";

export default function TodoList() {
  const [todos, setTodos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const data = await getAllTodos();
      setTodos(data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteTodo(id);
      fetchTodos();
    } catch (error) {
      console.log(error);
    }
  };

  // 🔥 LOGOUT FUNCTION
  const handleLogout = () => {
    localStorage.removeItem("token"); // remove JWT
    navigate("/login"); // go to login page
  };

  return (
    <div style={container}>
      <div style={card}>
        
        {/* 🔝 TOP BAR */}
        <div style={topBar}>
          <h2 style={{ margin: 0 }}>📋 Todo List</h2>

          <button onClick={handleLogout} style={logoutBtn}>
            🚪 Logout
          </button>
        </div>

        {/* TABLE */}
        <table style={table}>
          <thead>
            <tr style={{ background: "#5b86e5", color: "#fff" }}>
              <th style={th}>ID</th>
              <th style={th}>Title</th>
              <th style={th}>Description</th>
              <th style={th}>Edit</th>
              <th style={th}>Delete</th>
            </tr>
          </thead>

          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id} style={{ textAlign: "center" }}>
                <td style={td}>{todo.id}</td>
                <td style={td}>{todo.title}</td>
                <td style={td}>{todo.description}</td>

                <td style={td}>
                  <button
                    onClick={() => navigate(`/edit/${todo.id}`)}
                    style={editBtn}
                  >
                    Edit
                  </button>
                </td>

                <td style={td}>
                  <button
                    onClick={() => handleDelete(todo.id)}
                    style={deleteBtn}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        {/* ADD BUTTON */}
        <div style={{ textAlign: "center", marginTop: "20px" }}>
          <button
            onClick={() => navigate("/create")}
            style={addBtn}
          >
            ➕ Add Todo
          </button>
        </div>

      </div>
    </div>
  );
}

//////////////////////////////////////////////////
// 🎨 STYLES
//////////////////////////////////////////////////

const container = {
  minHeight: "100vh",
  background: "linear-gradient(135deg, #36d1dc, #5b86e5)",
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  fontFamily: "Arial",
};

const card = {
  background: "#fff",
  padding: "25px",
  borderRadius: "12px",
  width: "80%",
  maxWidth: "900px",
  boxShadow: "0 8px 20px rgba(0,0,0,0.2)",
};

const topBar = {
  display: "flex",
  justifyContent: "space-between",
  alignItems: "center",
};

const table = {
  width: "100%",
  borderCollapse: "collapse",
  marginTop: "20px",
};

const th = {
  padding: "10px",
};

const td = {
  padding: "10px",
  borderBottom: "1px solid #ddd",
};

const editBtn = {
  padding: "6px 12px",
  background: "#28a745",
  color: "#fff",
  border: "none",
  borderRadius: "6px",
  cursor: "pointer",
};

const deleteBtn = {
  padding: "6px 12px",
  background: "#dc3545",
  color: "#fff",
  border: "none",
  borderRadius: "6px",
  cursor: "pointer",
};

const addBtn = {
  padding: "10px 20px",
  background: "#5b86e5",
  color: "#fff",
  border: "none",
  borderRadius: "20px",
  fontSize: "16px",
  cursor: "pointer",
};

const logoutBtn = {
  padding: "8px 15px",
  background: "#ff4757",
  color: "#fff",
  border: "none",
  borderRadius: "8px",
  cursor: "pointer",
};